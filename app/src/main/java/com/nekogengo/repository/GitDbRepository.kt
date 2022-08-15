package com.nekogengo.repository

import com.nekogengo.services.GitDbServices

class GitDbRepository(
    private val gitDbServices: GitDbServices
) {
    suspend fun getTestJson(): Map<String, String> = gitDbServices.getTestJson()
}