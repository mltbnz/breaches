package de.db.mbnz.breaches.ViewModels

import de.db.mbnz.breaches.Models.Breach
import java.io.Serializable

/**
 * Created by mbnz on 16.11.17.
 */

final class DetailViewModel(val breach: Breach): Serializable {

    val title: String
        get() {
            return breach.Title.capitalize()
        }

    val descriptionHtml: String
        get() {
            return styleTemplate + breach.Description
        }

    companion object {
        val styleTemplate: String
            get() {
                return """
                        <style>
                            body {
                                background-color: #282a36;
                                color: white;
                            }
                            a {
                                color: hotpink;
                            }
                        </style>
                    """.trimIndent()
            }
    }

}