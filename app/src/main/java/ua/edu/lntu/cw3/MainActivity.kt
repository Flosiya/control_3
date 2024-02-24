package ua.edu.lntu.cw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import ua.edu.lntu.cw3.ui.theme.IPZ_CR_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CR_3Theme {
                Surface(color = MaterialTheme.colorScheme.background) {

                }
            }
        }
    }
}

data class User(val id: Int, val name: String)

fun generateUserList(): List<User> {
    return (1..4).map { User(it, "User $it") }
}



