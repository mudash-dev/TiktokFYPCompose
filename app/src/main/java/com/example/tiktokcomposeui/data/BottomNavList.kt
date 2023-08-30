package com.example.tiktokcomposeui.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.PeopleAlt
import androidx.compose.material.icons.filled.Person

val bottomNavItems = listOf(
    BottomNavItem(
        name = "Home",
        route = "home",
        icon = Icons.Filled.Home
    ),
    BottomNavItem(
        name = "Friends",
        route = "friends",
        icon = Icons.Filled.PeopleAlt
    ),
    BottomNavItem(
        name = "Inbox",
        route = "inbox",
        icon = Icons.Filled.Inbox
    ),
    BottomNavItem(
        name = "Profile",
        route = "profile",
        icon = Icons.Filled.Person
    ),
)