package com.toy.cardapp.ui.card

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.toy.cardapp.repository.fake.FakeTimeRepository
import com.toy.cardapp.viewmodel.NewsViewModel
import com.toy.cardapp.viewmodel.TimeViewModel

@Preview
@Composable
internal fun TimeCard(viewModel: TimeViewModel = TimeViewModel()) {
    val timeState = viewModel.time.collectAsState()
    val context = LocalContext.current
    GlobalCard(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        onClick = { makeToast(context, " time card clicked") }
    ) {
        Text(text = "time in ms: ${timeState.value.timeInMillis}")
    }
}