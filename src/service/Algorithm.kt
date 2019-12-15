@file:JvmName("Algorithm")

package service

import data.Student
import java.lang.String.format

fun simple(student: Student): Double {
    var numerator = 0.0
    var denominator = 0.0
    for (c in student.courses().values) {
        val score = c.score
        val credit = c.credit
        numerator += credit *
                when (score) {
                    in 90.0 .. 100.0 -> 4.0
                    in 80.0 .. 100.0 -> 3.0
                    in 70.0 .. 100.0 -> 2.0
                    in 60.0 .. 100.0 -> 1.0
                    else             -> 0.0
                }
        denominator += credit
    }
    return numerator / denominator
}

fun standard(student: Student): Double {
    var numerator = 0.0
    var denominator = 0.0
    for (c in student.courses().values) {
        val score = c.score
        val credit = c.credit
        numerator += score * credit
        denominator += credit
    }
    numerator /= 25
    return numerator / denominator
}

fun standardAdvanced1(student: Student): Double {
    var numerator = 0.0
    var denominator = 0.0
    for (c in student.courses().values) {
        val score = c.score
        val credit = c.credit
        numerator += credit *
                when (score) {
                    in 85.0 .. 100.0 -> 4.0
                    in 70.0 .. 100.0 -> 3.0
                    in 60.0 .. 100.0 -> 2.0
                    else             -> 0.0
                }
        denominator += credit
    }
    return numerator / denominator
}

fun standardAdvanced2(student: Student): Double {
    var numerator = 0.0
    var denominator = 0.0
    for (c in student.courses().values) {
        val score = c.score
        val credit = c.credit
        numerator += credit *
                when (score) {
                    in 85.0 .. 100.0 -> 4.0
                    in 75.0 .. 100.0 -> 3.0
                    in 60.0 .. 100.0 -> 2.0
                    else             -> 0.0
                }
        denominator += credit
    }
    return numerator / denominator
}

fun pekingUniversity(student: Student): Double {
    var numerator = 0.0
    var denominator = 0.0
    for (c in student.courses().values) {
        val score = c.score
        val credit = c.credit
        numerator += credit *
                when (score) {
                    in 90.0 .. 100.0 -> 4.0
                    in 85.0 .. 100.0 -> 3.7
                    in 82.0 .. 100.0 -> 3.3
                    in 78.0 .. 100.0 -> 3.0
                    in 75.0 .. 100.0 -> 2.7
                    in 72.0 .. 100.0 -> 2.3
                    in 69.0 .. 100.0 -> 2.0
                    in 66.0 .. 100.0 -> 1.7
                    in 63.0 .. 100.0 -> 1.3
                    in 60.0 .. 100.0 -> 1.0
                    else             -> 0.0
                }
        denominator += credit
    }
    return numerator / denominator
}

fun zhejiangUniversity(student: Student): Double {
    var numerator = 0.0
    var denominator = 0.0
    for (c in student.courses().values) {
        val score = c.score
        val credit = c.credit
        numerator += credit *
                when (score) {
                    in 85.0 .. 100.0 -> 4.0
                    else             -> (score - 45) / 10
                }
        denominator += credit
    }
    return numerator / denominator
}

fun worldEducationService(student: Student): Double {
    var numerator = 0.0
    var denominator = 0.0
    for (c in student.courses().values) {
        val score = c.score
        val credit = c.credit
        numerator += credit *
                when (score) {
                    in 85.0 .. 100.0 -> 4.0
                    in 75.0 .. 100.0 -> 3.0
                    in 60.0 .. 100.0 -> 2.0
                    else             -> 1.0
                }
        denominator += credit
    }
    return numerator / denominator
}

fun canadaFourPointThree(student: Student): Double {
    var numerator = 0.0
    var denominator = 0.0
    for (c in student.courses().values) {
        val score = c.score
        val credit = c.credit
        numerator += credit *
                when (score) {
                    in 90.0 .. 100.0 -> 4.3
                    in 85.0 .. 100.0 -> 4.0
                    in 80.0 .. 100.0 -> 3.7
                    in 75.0 .. 100.0 -> 3.3
                    in 70.0 .. 100.0 -> 3.0
                    in 65.0 .. 100.0 -> 2.7
                    in 60.0 .. 100.0 -> 2.3
                    else             -> 0.0
                }
        denominator += credit
    }
    return numerator / denominator
}

fun northeasternUniversityFive(student: Student): Double {
    var numerator = 0.0
    var denominator = 0.0
    for (c in student.courses().values) {
        val score = c.score
        val credit = c.credit
        numerator += credit *
                if (score >= 60.0) (score - 50.0) / 10.0
                else 0.0
        denominator += credit
    }
    return numerator / denominator
}

fun result(s: Student): String {
    val f = "%.4f"
    return "简单算法:\t\t\t${format(f, simple(s))}\n" +
            "标准算法:\t\t\t${format(f, standard(s))}\n" +
            "标准改进(1):\t\t${format(f, standardAdvanced1(s))}\n" +
            "标准改进(2):\t\t${format(f, standardAdvanced2(s))}\n" +
            "北大算法:\t\t\t${format(f, pekingUniversity(s))}\n" +
            "浙大算法:\t\t\t${format(f, zhejiangUniversity(s))}\n" +
            "WES算法:\t\t\t${format(f, worldEducationService(s))}\n" +
            "加拿大(4.3分制):\t${format(f, canadaFourPointThree(s))}\n" +
            "东北大学(5分制):\t${format(f, northeasternUniversityFive(s))}"
}