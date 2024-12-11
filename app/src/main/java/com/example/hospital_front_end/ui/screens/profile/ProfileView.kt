package com.example.hospital_front_end.ui.screens.profile

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hospital_front_end.R
import com.example.hospital_front_end.model.nurse.Nurse
import com.example.hospital_front_end.nurseRepository.NurseRepository
import com.example.hospital_front_end.ui.navigation.NurseExtendedItem


@Composable
fun ProfileView(nurse: Nurse, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .padding(top = 20.dp)
    ) {

        IconButton(onClick = onBack, modifier = Modifier.align(Alignment.End)) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "Back")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NurseExtendedItem(
                nurse = nurse
            )
        }

    }

}


@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProfileViewPreview() {
    ProfileView(
        nurse = NurseRepository().getNurseList()[0],
        onBack = { /* Simulated Back Action */ }
    )
}