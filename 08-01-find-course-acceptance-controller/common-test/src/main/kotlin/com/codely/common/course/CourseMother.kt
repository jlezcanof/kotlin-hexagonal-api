package com.codely.common.course

import com.codely.course.domain.course.Course
import com.codely.course.domain.course.CourseId
import com.codely.course.domain.course.CourseName
import java.time.LocalDateTime

object CourseMother {

    fun sample(
        id: String = "ce30c1ad-bcf9-47f3-9228-fca9ab081f57",
        name: String = "Course Mother Name",
        createdAt: LocalDateTime = LocalDateTime.parse("2022-08-31T09:00:00")
    ) = Course(
        id = CourseId.fromString(id),
        name = CourseName(name),
        createdAt = createdAt
    )
}
