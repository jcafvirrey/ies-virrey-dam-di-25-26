Abstracción
Oculta los detalles de cómo se hace algo, mostrando solo lo necesario.
StudentRepository define las operaciones sin mostrar cómo se guardan los datos.

Polimorfismo
Permite usar distintas clases que comparten una misma interfaz o comportamiento.
StudentService usa la interfaz StudentRepository, y puede funcionar con cualquier implementación.

Reutilización
Permite aprovechar código existente en otros programas o contextos.
Student, StudentRepository y StudentService se pueden reutilizar en proyectos distintos.