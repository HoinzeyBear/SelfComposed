package com.example.selfcomposed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.selfcomposed.blog.coroutines.CoroutinesCourse
import com.example.selfcomposed.ui.theme.SelfComposedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SelfComposedTheme {
                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    println("Drawing root surface")
//                    AllAboutState()
//                    PasswordField()
//                    KeyboardInputToNextFormField()
//                    Twitter()
//                    TopBarMenuWithSubMenu()
                    CoroutinesCourse()
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SelfComposedTheme {
        Greeting("Android")
    }
}