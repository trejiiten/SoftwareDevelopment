import UIKit

// BAD!!
var employee1Salary = 45000.0
var employee2Salary = 100000.0
var employee3Salary = 54000.0
var employee4Salary = 20000.0

employee1Salary = employee1Salary + (employee1Salary * 0.10)
// Repeat tediously ...


var salaries = [45000.0, 100000.0, 54000.0, 20000.0]
salaries[0] = salaries[0] + (salaries[0] * 0.10)
// still tedious ...

var x = 0
repeat {
    salaries[x] = salaries[x] + (salaries[x] * 0.10)
    x += 1
} while (x < salaries.count)

// for - in loop
for x in 1...5 {
    print("Index: \(x)")
} // Range: all inclusive

for z in 1..<5 {
    print("Index Z: \(z)")
}

for i in 0..<salaries.count {
    salaries[i] = salaries[i] + (salaries[i] * 0.10)
} // Loop is Exclusive: Loop finishes once condition (salaries.count) is met

// for - each loop
for salary in salaries {
    print("Salary: \(salary)")
} // for each salary in salaries ...
