package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                var name by remember {
                    mutableStateOf("")
                }
                var nameList by remember {
                    mutableStateOf(listOf<String>())
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row (
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextField(
                            value = name,
                            modifier = Modifier.weight(1f),
                            onValueChange = { text ->
                                name = text
                            }
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(onClick = {
                            if(name.isNotBlank()) {
                                nameList = nameList + name
                                name = ""
                            }
                        }) {
                            Text(text = "Add")
                        }
                    }

                    LazyColumn {
                        items(nameList) { text ->
                            Text(text = text,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp))
                            Divider()
                        }
                    }
                }
            }
        }
    }
}