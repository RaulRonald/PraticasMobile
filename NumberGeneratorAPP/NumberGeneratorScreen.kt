package com.example.numbergenerator.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.numbergenerator.NumberUiState
import com.example.numbergenerator.NumberViewModel

@Composable
fun NumberGeneratorScreen(
    viewModel: NumberViewModel = viewModel()
) {
    when (val state = viewModel.uiState) {
        is NumberUiState.Idle -> IdleContent(onGenerate = viewModel::generateNumber)
        is NumberUiState.Loading -> LoadingContent()
        is NumberUiState.Success -> SuccessContent(
            number = state.value,
            onGenerate = viewModel::generateNumber
        )
        is NumberUiState.Failure -> ErrorContent(
            message = state.errorMessage,
            onRetry = viewModel::generateNumber
        )
    }
}

@Composable
private fun IdleContent(onGenerate: () -> Unit) {
    CenteredColumn {
        Button(onClick = onGenerate) {
            Text(text = "Gere um número aleatório")
        }
    }
}

@Composable
private fun LoadingContent() {
    CenteredColumn {
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "A gerar número")
    }
}

@Composable
private fun SuccessContent(
    number: Int,
    onGenerate: () -> Unit
) {
    CenteredColumn {
        Text(
            text = "Número gerado = $number",
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = onGenerate) {
            Text(text = "Gerar novo número")
        }
    }
}

@Composable
private fun ErrorContent(
    message: String,
    onRetry: () -> Unit
) {
    CenteredColumn {
        Text(
            text = message,
            color = MaterialTheme.colors.error
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onRetry) {
            Text(text = "Tentar novamente")
        }
    }
}

@Composable
private fun CenteredColumn(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun NumberGeneratorPreview() {
    NumberGeneratorScreen()
}
