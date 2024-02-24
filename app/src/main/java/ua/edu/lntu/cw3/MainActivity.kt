package ua.edu.lntu.cw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ua.edu.lntu.cw3.ui.theme.IPZ_CR_3Theme
import androidx.compose.ui.tooling.preview.Preview

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

@Composable
fun UserList(users: List<User>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(users) { user ->
            UserItem(user = user)
        }
    }
}

@Composable
fun UserItem(user: User) {
    Text(text = "User ID: ${user.id}, Name: ${user.name}")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserListPreview() {
    IPZ_CR_3Theme {
        UserList(users = generateUserList())
    }
}




