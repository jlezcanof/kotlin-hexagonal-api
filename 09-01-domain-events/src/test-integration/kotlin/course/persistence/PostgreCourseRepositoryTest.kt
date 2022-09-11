package course.persistence

import com.codely.course.domain.course.Course
import com.codely.course.domain.course.CourseId
import com.codely.course.domain.course.CourseName
import com.codely.course.infrastructure.persistence.PostgreCourseRepository
import com.codely.shared.Application
import java.time.LocalDateTime
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ContextConfiguration
import shared.persistence.BaseIntegrationTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = [Application::class])
class PostgreCourseRepositoryTest : BaseIntegrationTest() {

    @Autowired
    private lateinit var repository: PostgreCourseRepository

    @Test
    fun `should save a course`() {
        val courseId = "13590efb-c181-4c5f-9f95-b768abde13e2"
        val courseToSave = Course(CourseId.fromString(courseId), CourseName("Test"), LocalDateTime.now(), listOf())
        repository.save(courseToSave)

        val courseFromDb = repository.find(CourseId.fromString(courseId))

        assertEquals(Result.success(courseToSave), courseFromDb)
    }
}