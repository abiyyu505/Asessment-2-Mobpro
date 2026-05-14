package com.abiyyu0003.mobpro1.ui.screen

import androidx.lifecycle.ViewModel
import com.abiyyu0003.mobpro1.model.Catatan

class MainViewModel : ViewModel() {

    val data = listOf(
        Catatan(
            id = 1L,
            judul_materi = "Mobpro - Day 1",
            isi_materi = "Perkenalan dengan dosen pengampu dan mata kuliah mobpro",
            tanggal = "1 Mei 2026"
        ),
        Catatan(
            id = 2L,
            judul_materi = "Mobpro - Day 2",
            isi_materi = "Build Your First App",
            tanggal = "7 Mei 2026"
        ),
        Catatan(
            id = 3L,
            judul_materi = "Mobpro - Day 3",
            isi_materi = "Working with images",
            tanggal = "13 Mei 2026"
        ),
        Catatan(
            id = 4L,
            judul_materi = "Mobpro - Day 4",
            isi_materi = "Get User Input",
            tanggal = "19 Mei 2026"
        ),
        Catatan(
            id = 5L,
            judul_materi = "Mobpro - Day 5",
            isi_materi = "App Navigation",
            tanggal = "25 Mei 2026"
        )
    )
}