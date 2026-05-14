package com.abiyyu0003.asessment2mobpro.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.abiyyu0003.asessment2mobpro.R
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext
import com.abiyyu0003.asessment2mobpro.database.CatatanDb
import com.abiyyu0003.asessment2mobpro.util.ViewModelFactory
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavHostController, id: Long = 0L) {

    val judul = remember { mutableStateOf("") }
    val isi = remember { mutableStateOf("") }
    val context = LocalContext.current
    val db = CatatanDb.getInstance(context)
    val factory = ViewModelFactory(db.dao)
    val viewModel: DetailViewModel = viewModel(factory = factory)

    var expanded by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (id == 0L) {
                            stringResource(R.string.tambah_catatan)
                        } else {
                            stringResource(R.string.ubah_catatan)
                        }
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.tombol_kembali)
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            if (judul.value.isNotBlank() && isi.value.isNotBlank()) {
                                if (id == 0L) {
                                    viewModel.insert(judul.value, isi.value)
                                } else {
                                    viewModel.update(id, judul.value, isi.value)
                                }
                                navController.popBackStack()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = stringResource(R.string.tombol_simpan)
                        )
                    }
                }
            )
        }

    ) { innerPadding ->
        FormCatatan(
            title = judul.value,
            onTitleChange = { judul.value = it },
            desc = isi.value,
            onDescChange = { isi.value = it },
            modifier = Modifier.padding(innerPadding)
        )
    }
    if (showDialog) {
        DisplayAlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            onConfirmation = {
                showDialog = false
                viewModel.delete(id)
                navController.popBackStack()
            }
        )
    }
}


@Composable
fun FormCatatan(
    title: String,
    onTitleChange: (String) -> Unit,
    desc: String,
    onDescChange: (String) -> Unit,
    modifier: Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { onTitleChange(it) },
            label = { Text(text = stringResource(R.string.judul_materi)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = desc,
            onValueChange = { onDescChange(it) },
            label = { Text(text = stringResource(R.string.isi_materi)) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}