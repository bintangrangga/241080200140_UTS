package com.example.a241080200140_uts.soal4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class JadwalKuliah(
    val waktu: String,
    val mataKuliah: String,
    val ruangan: String
)

class Soal4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    JadwalKuliahScreen()
                }
            }
        }
    }
}

@Composable
fun JadwalKuliahScreen() {
    val daftarHari = listOf("Senin", "Selasa", "Rabu", "Kamis")
    var hariTerpilih by rememberSaveable { mutableStateOf("Senin") }

    val daftarJadwal = listOf(
        JadwalKuliah(
            waktu = "08.00 - 09.40",
            mataKuliah = "Pemrograman Mobile",
            ruangan = "Ruang Lab 2"
        ),
        JadwalKuliah(
            waktu = "10.00 - 11.40",
            mataKuliah = "Basis Data",
            ruangan = "Ruang 304"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Jadwal Kuliah",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 12.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            daftarHari.forEach { hari ->
                FilterChip(
                    selected = (hari == hariTerpilih),
                    onClick = { hariTerpilih = hari },
                    label = { Text(text = hari) }
                )
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = daftarJadwal,
                key = { jadwal -> jadwal.mataKuliah }
            ) { jadwal ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = jadwal.waktu,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = jadwal.mataKuliah,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = jadwal.ruangan,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Preview Jadwal Kuliah")
@Composable
fun JadwalKuliahScreenPreview() {
    MaterialTheme {
        JadwalKuliahScreen()
    }
}
