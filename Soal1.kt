package com.example.a241080200140_uts.Soal1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Soal1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    KeranjangScreen()
                }
            }
        }
    }
}

@Composable
fun KeranjangScreen() {
    var qty by rememberSaveable { mutableIntStateOf(1) }
    val harga = 25000

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Jumlah: $qty")
        Text(text = "Total: Rp ${qty * harga}")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { qty++ }) {
                Text("Tambah")
            }
            Button(onClick = { if (qty > 1) qty-- }) {
                Text("Kurangi")
            }
        }
    }
}

@Preview(showBackground = true, name = "Preview Keranjang")
@Composable
fun KeranjangScreenPreview() {
    MaterialTheme {
        KeranjangScreen()
    }
}
