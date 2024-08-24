package com.example.divagar

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.divagar.ui.theme.DivagarTheme
import com.walmartlabs.ern.container.ElectrodeReactContainer
import com.walmartlabs.ern.container.miniapps.MyminiappActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialization
        ElectrodeReactContainer.initialize(
            applicationContext as Application,
            ElectrodeReactContainer.Config()
                .isReactNativeDeveloperSupport(true)
        )

        setContent {
            DivagarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    Button(
                        modifier = Modifier
                            .padding(horizontal = 100.dp, vertical = 300.dp), onClick = {
                            Log.i("Divagar Says", "Clicked")

                            startActivity(Intent(applicationContext, MyminiappActivity::class.java))

                        }
                    ) {
                        Text(text = "Start React Native Activity")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DivagarTheme {
        Greeting("Android")
    }
}