package com.example.selfcomposed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.selfcomposed.blog.coroutines.CoroutinesCourse
import com.example.selfcomposed.ui.theme.SelfComposedTheme
import com.example.selfcomposed.workshop.TopBarMenuWithSubMenu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SelfComposedTheme {
                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//                    println("Drawing root surface")
//                    AllAboutState()
//                    PasswordField()
//                    KeyboardInputToNextFormField()
//                    Twitter()
//                    TopBarMenuWithSubMenu()
                    CoroutinesCourse()
//                    Tweet()
//                    TopBarMenuWithSubMenu()
//                    TextColoring()
//                CheckboxInRowWithText()
//                CheckboxInRowWithTextAnswer1()
//                ViewPagerDemo()
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