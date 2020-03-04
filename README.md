# Code Review / Refactoring exercise
Please review the following code snippet. Assume that all referenced assemblies have been properly included. 
The code is used to log different messages throughout an application. We want the ability to be able to log to a text file, the console and/or the database. Messages can be marked as message, warning or error. We also want the ability to selectively be able to choose what gets logged, such as to be able to log only errors or only errors and warnings. 
1.	If you were to review the following code, what feedback would you give? Please be specific and indicate any errors that would occur as well as other best practices and code refactoring that should be done. 
2.	Rewrite the code based on the feedback you provided in question 1. 

## Revisión de código
- Variable initialized, declarada pero no utilizada
- Separar Modelo del Controlador, creando un objeto JobLogger
- La declaración del método LogMessage contiene parámetros innecesarios "boolean message, boolean warning, boolean error" ya que se puede determinar por los parámetros del constructor
- Relacionado al punto anterior, la mayoria de los condicionales evalúan dos parámetros que aportan lo mismo ejemplo message && logMessage cuando puede depender de una sola variable
- Hace un trim de la variable messageText pero no guarda el resultado, si hace un trim de un null arroja Exception
- Se debe crear una clase con la conexión y solo invocarla si logToDatabase == true ya que no tiene sentido hacer una coxeion si logToDatabase == false
- Variable "t" no aporta legibilidad al código, hay que hacer seguimiento para identificar su funcionalidad, se podría renombrar por valueLevel.
- Utiliza dbParams para configurar ruta y nombre de archivo se debería renombrar la variable o separar los parámetros de conexión de base de datos por un lado y escritura de archivos por otro
- La variable logFile no debe crear el archivo, ya que se crea con FileHandler, lo que debe crear es el directorio, con el metodo mkdir() no createNewFile(). Se debe renombrar la variable por ejemplo patch
- Al crear una instancia de FileHandler falta parámetro append ya que si no se informa sobrescribe el archivo. Al colocar en true escribe en el mismo archivo sin borrar lo anterior
- FileHandler(String pattern, boolean append) throws IOException, SecurityException La documentacion del método informa que puede retornar dos Exception, las mismas no se capturan ni se muestran.
- Asignar a l = l +"error".. cuando se declaro como null, concatena nullErrorFecha.
- Al colocar los 3 if consecutivos evaluando el tipo de error y concatenando a la misma variable "l" si la condicion es true para los 3 casos, retornaría una sola cadena con todo concatenado y sin espacios por ejemplo "nullerror 2 de marzo de 2020Mensajewarning 2 de marzo de 2020Mensajemessage 2 de marzo de 2020Mensaje"
- La variable "l" es declarada, se le asigna una cadena, pero no se utiliza.
- Sentencia SQL mal formulada faltan atributos y palabra reservada VALUES
- No se cierran la conexiones tanto la base de datos como el archivo log

## En el repositorio en cuestion se encuentra el codigo refactorizado

#### Tecnología Utilizada
- Netbeans IDE 8.2
- Java 1.8
- Maven
- Sprint Boot 2.2.5

