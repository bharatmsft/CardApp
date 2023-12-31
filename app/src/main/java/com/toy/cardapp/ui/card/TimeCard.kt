package com.toy.cardapp.ui.card

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.toy.cardapp.viewmodel.TimeViewModel

@Composable
internal fun TimeCard(viewModel: TimeViewModel) {
    val timeState = viewModel.time.collectAsState()
    val context = LocalContext.current
    TimeCard(
        timeInMillis = timeState.value.timeInMillis,
        onClick = { makeToast(context, "time card clicked") }
    )
}

@Preview
@Composable
internal fun TimeCard(
    timeInMillis: Long = 0L,
    onClick : () -> Unit = {}
) {
    GlobalCard(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        onClick = onClick
    ) {
        Text(text = "time in ms: $timeInMillis")
    }
}