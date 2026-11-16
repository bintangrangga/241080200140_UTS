package com.example.a241080200140_uts.soal2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Soal2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    DaftarMahasiswa()
                }
            }
        }
    }
}

@Composable
fun DaftarMahasiswa() {
    val nama = listOf("Ayu", "Beni", "Citra", "Doni")

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(
            items = nama,
            key = { item -> item }
        ) { item ->
            Text(
                text = item,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true, name = "Preview Daftar Mahasiswa")
@Composable
fun DaftarMahasiswaPreview() {
    MaterialTheme {
        DaftarMahasiswa()
    }
}
