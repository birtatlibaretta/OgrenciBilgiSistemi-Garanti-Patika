class Course:
    def __init__(self, name, code, prefix):
        self.name = name
        self.code = code
        self.prefix = prefix
        self.note = 0.0
    
    def setNoteWeight(self, note_weight):
        self.note_weight = note_weight
    
    def addNote(self, note):
        self.note = note
    
    def calculateWeightedNote(self):
        return self.note * self.note_weight


class Student:
    def __init__(self, name, student_number):
        self.name = name
        self.student_number = student_number
        self.courses = []
    
    def addCourse(self, course):
        self.courses.append(course)
    
    def calculateAverage(self):
        total_weighted_note = 0.0
        total_note_weight = 0.0
        for course in self.courses:
            total_weighted_note += course.calculateWeightedNote()
            total_note_weight += course.note_weight
        if total_note_weight == 0:
            return 0.0
        return total_weighted_note / total_note_weight
    
    def isPassing(self):
        average = self.calculateAverage()
        if average >= 50:
            return True
        return False


# Test İşlemleri
# Ders oluşturma
course1 = Course("Fizik", "PHY101", "PHY")
course2 = Course("Matematik", "MAT101", "MAT")
course3 = Course("Kimya", "CHEM101", "CHEM")

# Derslere not ağırlıklarını belirleme
course1.setNoteWeight(0.20)
course2.setNoteWeight(0.30)
course3.setNoteWeight(0.25)

# Öğrenci oluşturma
student1 = Student("Alice", "001")

# Öğrencinin aldığı notları ekleme
course1.addNote(90)
course2.addNote(60)
course3.addNote(70)

# Öğrencinin derslerine kaydetme
student1.addCourse(course1)
student1.addCourse(course2)
student1.addCourse(course3)

# Ortalama hesaplama
average = student1.calculateAverage()

# Geçme durumunu kontrol etme
passing_status = student1.isPassing()

# Sonuçları görüntüleme
print(f"Öğrenci: {student1.name}")
print(f"Öğrenci Numarası: {student1.student_number}")
print(f"Ortalama: {average:.2f}")
if passing_status:
    print("Durum: Geçti")
else:
    print("Durum: Kaldı")
