package views

import views.html.helper.FieldConstructor

package object fieldsConstructors {
    val bFieldContructors =
            FieldConstructor(f => views.html.fieldsConstructors.bootstrapFieldConstructor(f))
}
