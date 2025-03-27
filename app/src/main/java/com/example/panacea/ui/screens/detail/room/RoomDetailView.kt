package com.example.panacea.ui.screens.detail.room

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.panacea.domain.models.patient.Patient
import com.example.panacea.ui.navigation.HOME
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomDetailView(
    roomId: Int,
    nav: NavHostController,
    vm: RoomDetailViewModel = koinViewModel { parametersOf(roomId) }
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            nav.popBackStack()
                            nav.navigate(HOME)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier.size(35.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                colors = TopAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color.Transparent,
                    navigationIconContentColor = Color.Transparent,
                    titleContentColor = Color.Transparent,
                    actionIconContentColor = Color.Transparent,
                ),
                title = { Text("ROOM ${vm.data.room?.name}", color = MaterialTheme.colorScheme.onBackground) },
            )
        },
    ) { innerPadding ->
        if (vm.state.isLoading) {
            CircularProgressIndicator()
        } else {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                PatientDetailsColumn(patient = vm.data.room?.patient!!)
            }
        }
    }
}

@Composable
fun PatientDetailsColumn(patient: Patient, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Sección: Información Personal
        SectionTitle(title = "Información Personal")
        DetailItem(label = "Nombre", value = "${patient.name} ${patient.surname}")
        DetailItem(label = "Fecha de Nacimiento", value = patient.birthDate)
        DetailItem(label = "Idioma", value = patient.language)

        Spacer(modifier = Modifier.height(16.dp))

        // Sección: Información de Contacto
        SectionTitle(title = "Información de Contacto")
        DetailItem(label = "Dirección", value = patient.direction)
        DetailItem(label = "Correo", value = patient.email)

        Spacer(modifier = Modifier.height(16.dp))

        // Sección: Información Médica
        SectionTitle(title = "Información Médica")
        DetailItem(label = "Alergias", value = patient.allergies)
        patient.diagnosis?.let {
            DetailItem(label = "Diagnóstico", value = it.toString())
        }
        DetailItem(label = "Historial Médico", value = patient.medicalHistory)
        DetailItem(label = "Higiene", value = patient.hygiene)
        patient.mobilization?.let {
            DetailItem(label = "Movilización", value = it.toString())
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sección: Cuidador
        SectionTitle(title = "Cuidador")
        DetailItem(label = "Responsable", value = patient.caregiver)
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 8.dp)
    )
    Divider(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
}

@Composable
fun DetailItem(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$label:",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}