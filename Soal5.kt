package com.example.a241080200140_uts.soal5

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

fun hitungStatusTagihan(data: List<Int?>): Pair<Int, Int> {
    var lunas = 0
    var belum = 0
    for (nominal in data) {
        if ((nominal ?: 0) > 0) {
            lunas++
        } else {
            belum++
        }
    }
    return Pair(lunas, belum)
}

fun main() {
    val daftarTagihan: List<Int?> = listOf(500000, 0, null, 750000, 0, 250000, null)
    val (jumlahLunas, jumlahBelum) = hitungStatusTagihan(daftarTagihan)

    println("Data Tagihan       : $daftarTagihan")
    println("Sudah Dibayar      : $jumlahLunas tagihan")
    println("Belum Dibayar      : $jumlahBelum tagihan")
}

@Preview(showBackground = true, name = "Preview Hasil Hitung Tagihan")
@Composable
fun HitungStatusTagihanPreview() {
    val daftarTagihan: List<Int?> = listOf(500000, 0, null, 750000, 0, 250000, null)
    val (jumlahLunas, jumlahBelum) = hitungStatusTagihan(daftarTagihan)

    MaterialTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Data Tagihan: $daftarTagihan")
            Text(text = "Sudah Dibayar: $jumlahLunas tagihan")
            Text(text = "Belum Dibayar: $jumlahBelum tagihan")
        }
    }
}
