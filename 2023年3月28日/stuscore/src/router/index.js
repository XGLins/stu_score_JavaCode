import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/home/Home'
import Student from '@/sc/student/Student'
import Teacher from '@/sc/teacher/Teacher'
import Classes from '@/sc/classes/Classes'
import Course from '@/sc/course/Course'
import Score from '@/sc/score/Score'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
      children:[
        {
          path: '/student',
          name: 'student',
          component: Student
        },
        {
          path: '/teacher',
          name: 'teacher',
          component: Teacher
        },
        {
          path: '/classes',
          name: 'classes',
          component: Classes
        },
        {
          path: '/course',
          name: 'course',
          component: Course
        },
        {
          path: '/score',
          name: 'score',
          component: Score
        }
      ]
    }
    
  ]
})
