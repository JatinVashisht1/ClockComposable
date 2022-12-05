# Clock Composable
- This is a dummy application made to practice and increase my jetpack compose canvas skills
- Basic concepts applied in the app are
  - Drawing shapes (circle)
  - Drawing lines and rotating them (with respect to center of the circle)
  - Drawing or printing the text
  - Thinking in canvas
- Canvas skills can be upgraded by practicing only, more projects you make about it more your skills will increase

### Main Files:
- [MainActivity.kt](/app/src/main/java/com/jatinvashisht/clockcomposableexercise/MainActivity.kt) contains code of calling the Composable and providing it with hours, seconds, minutes
- [ClockComposable.kt](/app/src/main/java/com/jatinvashisht/clockcomposableexercise/clock/ClockComposable.kt) contains logic related to UI of clock
- [ClockStyle.kt](/app/src/main/java/com/jatinvashisht/clockcomposableexercise/clock/ClockStyle.kt) is a data class encapsulating the properties of elements used in ClockComposable.kt such has line length, radius, etc.