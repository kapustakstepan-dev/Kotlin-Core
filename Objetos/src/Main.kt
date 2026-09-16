import model.Document
import model.Person
import model.Student

fun main() {

    val person: Person = Person(
        "Borja", "Martin",
        "123A", "correo@gmail.com"
    )
    person.mostrarDatos()

    val document = Document( theme = "Sport")
    val document1 = Document("Autor", "Sport")
    val document2 = Document("Autor", extencion = 8)
    val document3 = Document("Autor", "sport", 8, "digital")

    val student: Student = Student(
        "Borja", "Martin",
        "123A", "correo@gmail.com", 123, 234
    )

    student.mostrarDatos()

}