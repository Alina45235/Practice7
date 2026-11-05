package com.example.practice7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice7.ui.theme.Practice7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practice7Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PracticeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticeScreen(modifier: Modifier = Modifier) {
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    Box(modifier = modifier.fillMaxSize()) {
        FloatingActionButton(
            modifier = Modifier
                .padding(32.dp)
                .align(Alignment.BottomEnd),
            onClick = { showBottomSheet = true },
            containerColor = Color.Gray,
            contentColor = Color.White,
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Open Bottom Sheet"
            )
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Это панель ModalBottomSheet",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        modifier = Modifier
                            .size(32.dp)
                            .padding(top = 16.dp),
                        imageVector = Icons.Default.Home,
                        contentDescription = "Icon"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PracticeScreenPreview() {
    Practice7Theme {
        PracticeScreen()
    }
}