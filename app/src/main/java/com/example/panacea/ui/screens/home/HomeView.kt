package com.example.panacea.ui.screens.home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.panacea.data.utils.Constants.MENU
import com.example.panacea.domain.models.room.Room
import com.example.panacea.ui.components.DrawerAppBar
import com.example.panacea.ui.navigation.ROOM_DETAIL

@Composable
fun HomeView(
    nav: NavHostController,
    vm: HomeViewModel
) {
    DrawerAppBar(
        nav = nav,
        index = MENU.OPTION_2,
        userName = "${vm.data.currentUser?.name} ${vm.data.currentUser?.surname}",
        pageTitle = { },
        userImage = "${vm.data.currentUser?.profileImage}",
        screenContent = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                when {
                    vm.state.isLoading -> {
                        CircularProgressIndicator()
                    }

                    vm.state.onSuccess -> {
                        RoomsGrid(
                            roomList = vm.data.roomList,
                            navigateDetail = { roomId ->
                                nav.navigate(ROOM_DETAIL(roomId = roomId))
                            }
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun FilterChipExample() {
    var selectedAll by remember { mutableStateOf(true) }
    var selectedAvailable by remember { mutableStateOf(false) }
    var selectedOccupied by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterChip(
            onClick = {
                selectedAll = true
                selectedAvailable = false
                selectedOccupied = false
            },
            label = {
                Text("Todas")
            },
            selected = selectedAll,
            leadingIcon = if (selectedAll) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            },
        )

        FilterChip(
            onClick = {
                selectedAll = false
                selectedAvailable = true
                selectedOccupied = false
            },
            label = {
                Text("Disponibles")
            },
            selected = selectedAvailable,
            leadingIcon = if (selectedAvailable) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            },
        )

        FilterChip(
            onClick = {
                selectedAll = false
                selectedAvailable = false
                selectedOccupied = true
            },
            label = {
                Text("Ocupadas")
            },
            selected = selectedOccupied,
            leadingIcon = if (selectedOccupied) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            },
        )
    }
}

@Composable
fun RoomsGrid(roomList: List<Room>, navigateDetail: (Int) -> Unit) {
    // Estado para almacenar el filtro seleccionado
    var filterState by remember { mutableStateOf("all") } // Valores posibles: "all", "available", "occupied"

    Column(modifier = Modifier.fillMaxSize()) {
        // Filtros en la parte superior
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                onClick = { filterState = "all" },
                label = { Text("All") },
                selected = filterState == "all",
                leadingIcon = if (filterState == "all") {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Todas seleccionadas",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else null
            )

            FilterChip(
                onClick = { filterState = "available" },
                label = { Text("Available") },
                selected = filterState == "available",
                leadingIcon = if (filterState == "available") {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Disponibles seleccionadas",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else null
            )

            FilterChip(
                onClick = { filterState = "occupied" },
                label = { Text("Occupied") },
                selected = filterState == "occupied",
                leadingIcon = if (filterState == "occupied") {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Ocupadas seleccionadas",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else null
            )
        }

        // Filtrar las habitaciones según el filtro seleccionado
        val filteredRooms = when (filterState) {
            "available" -> roomList.filter { it.patient == null }
            "occupied" -> roomList.filter { it.patient != null }
            else -> roomList // "all" o valor por defecto
        }

        // Grid con las habitaciones filtradas
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filteredRooms) { room ->
                RoomCard(
                    room = room,
                    navigateDetail = { if (room.patient != null) navigateDetail(room.id) }
                )
            }
        }
    }
}

@Composable
fun RoomCard(
    room: Room,
    navigateDetail: () -> Unit
) {
    val ocupacityColor = if (room.patient == null) Color(0xFF4CAF50) else Color(0xFFFF7844)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, ocupacityColor, MaterialTheme.shapes.medium)
            .clickable {
                navigateDetail()
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = ("ROOM " + room.name),
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = ("Section " + room.section),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (room.patient != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Outlined.Person,
                        contentDescription = null,
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.size(4.dp))

                    Text(
                        text = room.patient.name,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(Modifier.weight(1f))

                    Icon(
                        painter = painterResource(id = com.example.panacea.R.drawable.signos_vitales),
                        contentDescription = null,
                        modifier = Modifier
                            .size(ButtonDefaults.IconSize)
                            .clip(CircleShape)
                            .clickable {

                            },
                        tint = Color(0xFF4CAF50)
                    )
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Add Patient",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Icon(
                        Icons.Outlined.AddCircle,
                        contentDescription = null,
                        modifier = Modifier
                            .size(ButtonDefaults.IconSize)
                            .clip(CircleShape)
                            .clickable {

                            },
                        tint = Color(0xFF4CAF50)
                    )
                }
            }
        }
    }
}