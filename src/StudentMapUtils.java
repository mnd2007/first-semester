import java.util.*;

public class StudentMapUtils {

    public static List<Student> findStudentsByGradeRange(Map<Integer, Student> map,
                                                         double minGrade, double maxGrade) {
        List<Student> result = new ArrayList<>();

        for (Student student : map.values()) {
            if (student.getGrade() >= minGrade && student.getGrade() <= maxGrade) {
                result.add(student);
            }
        }

        return result;
    }

    public static List<Student> getTopNStudents(TreeMap<Integer, Student> map, int n) {
        List<Student> result = new ArrayList<>();

        int count = 0;
        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            if (count >= n) break;
            result.add(entry.getValue());
            count++;
        }

        return result;
    }

    public static List<Student> getTopNStudentsAlternative(TreeMap<Integer, Student> map, int n) {
        List<Student> result = new ArrayList<>();

        Iterator<Map.Entry<Integer, Student>> iterator = map.entrySet().iterator();

        int count = 0;
        while (iterator.hasNext() && count < n) {
            result.add(iterator.next().getValue());
            count++;
        }

        return result;
    }

    public static void main(String[] args) {
        Map<Integer, Student> hashMap = new HashMap<>();
        hashMap.put(1, new Student(1, "Alice", 4.5));
        hashMap.put(2, new Student(2, "Bob", 3.8));
        hashMap.put(3, new Student(3, "Charlie", 4.2));
        hashMap.put(4, new Student(4, "Diana", 3.5));
        hashMap.put(5, new Student(5, "Eve", 4.8));

        TreeMap<Integer, Student> treeMap = new TreeMap<>(Collections.reverseOrder());
        treeMap.putAll(hashMap);

        System.out.println("Студенты с оценкой от 4.0 до 4.5:");
        List<Student> gradeRangeStudents = findStudentsByGradeRange(hashMap, 4.0, 4.5);
        gradeRangeStudents.forEach(System.out::println);

        System.out.println("\nТоп 3 студента по id (с наибольшими id):");
        List<Student> topStudents = getTopNStudents(treeMap, 3);
        topStudents.forEach(System.out::println);

        System.out.println("\nTreeMap (сортировка по убыванию id):");
        treeMap.forEach((id, student) -> System.out.println("ID: " + id + " -> " + student));

        System.out.println("\nВсе студенты в HashMap:");
        hashMap.forEach((id, student) -> System.out.println("ID: " + id + " -> " + student));
    }
}