object ejs2110 {
//Ejercicio 3
trait Transporte {
  def costo(distancia: Double): Double
}

class Taxi(
  val tarifaMinimaBase: Double,
  val costoPorKm: Double
) extends Transporte {
  def costo(distancia: Double): Double =
    tarifaMinimaBase + (costoPorKm * distancia)
}

class Bus(
  val tarifa: Double
) extends Transporte {
  def costo(distancia: Double): Double =
    tarifa
}

def calcularViaje(
  transporte: Transporte,
  distancia: Double
): Double =
  transporte.costo(distancia)


//Ejercicio 5
trait Notificacion {
  def enviar(mensaje: String): String
}

class Email(
  val direccionEmail: String
) extends Notificacion {
  def enviar(mensaje: String): String =
    s"Email a $direccionEmail: $mensaje"
}

class SMS(
  val numTelefono: String
) extends Notificacion {
  def enviar(mensaje: String): String =
    s"SMS a $numTelefono: $mensaje"
}

class NotificacionPush(
  val dispositivo: String
) extends Notificacion {
  def enviar(mensaje: String): String =
    s"Notificacion Push a $dispositivo: $mensaje"
}

def enviarNotificacion(
  notificacion: Notificacion,
  mensaje: String
): String =
  notificacion.enviar(mensaje)

def main (args: Array[String]) = {
  val taxi = new Taxi(5.0, 2.5)
  val bus = new Bus(1.5)

  println(s"Costo Taxi: ${calcularViaje(taxi, 10.0)}")
  println(s"Costo Bus: ${calcularViaje(bus, 10.0)}")

  val email = new Email("usuario1@ejemplo.com")
  val sms = new SMS("70012345")
  val push = new NotificacionPush("notificacionPush")

  println(enviarNotificacion(email, "Hola"))
  println(enviarNotificacion(sms, "Tu codigo es 12345"))
  println(enviarNotificacion(push, "Nueva alerta"))
}
}