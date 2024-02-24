package ua.edu.lntu.cw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.lntu.cw3.ui.theme.IPZ_CR_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CR_3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserList(users = generateUserList())
                }
            }
        }
    }
}

data class User(val id: Int, val name: String)

fun generateUserList(): List<User> {
    return (1..10).map { User(it, "User $it") }
}

@Composable
fun UserList(users: List<User>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(users) { user ->
            UserItem(user = user)
            Spacer(modifier = Modifier.height(8.dp)) // Відступ між елементами
        }
    }
}

@Composable
fun UserItem(user: User) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = MaterialTheme.colorScheme.surface), // Фоновий колір елементу
        verticalArrangement = Arrangement.spacedBy(8.dp), // Відступ між внутрішніми елементами
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "User ID: ${user.id}",
            style = MaterialTheme.typography.headlineMedium // Стиль тексту для ID користувача
        )
        Text(
            text = "Name: ${user.name}",
            style = MaterialTheme.typography.bodyLarge // Стиль тексту для імені користувача
        )
        repeat(3) {
            RandomElement() // Відображення довільних елементів
        }
    }
}

@Composable
fun RandomElement() {
    val randomNumber = (0..2).random()
    val elementText = when (randomNumber) {
        0 -> "Element type A"
        1 -> "Element type B"
        else -> "Element type C"
    }
    Text(
        text = elementText,
        style = MaterialTheme.typography.bodyMedium // Стиль тексту для довільного елемента
    )
}

@Preview(showBackground = true)
@Composable
fun UserListPreview() {
    IPZ_CR_3Theme {
        UserList(users = generateUserList())
    }
}
