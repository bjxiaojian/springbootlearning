package com.example.myFirstProject.common.datasource;

import com.example.myFirstProject.dao.ShopDao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class DataSourceAspect {
    /**
     * 使用空方法定义切点表达式
     */
    @Pointcut("execution(* com.example.myFirstProject.dao.*.*(..))")
    public void declareJointPointExpression() {
    }

    /**
     * 使用定义切点表达式的方法进行切点表达式的引入
     */
    @Before("declareJointPointExpression()")
    public void setDataSourceKey(JoinPoint point){
        //连接点所属的类实例是ShopDao
        if(point.getTarget() instanceof ShopDao){
            DatabaseContextHolder.setDatabaseType(DatabaseType.test);
        }else{//连接点所属的类实例是UserDao（当然，这一步也可以不写，因为defaultTargertDataSource就是该类所用的mytestdb）
            DatabaseContextHolder.setDatabaseType(DatabaseType.mytest);
        }
    }
    
//    @Around("execution(* com.example.myFirstProject.dao.*.*(..))")
//    public Object setDataSourceKeyByAround(ProceedingJoinPoint point) throws Throwable{
//        if(point.getTarget() instanceof ShopDao){
//            DatabaseContextHolder.setDatabaseType(DatabaseType.mytest);
//        }else{//连接点所属的类实例是UserDao（当然，这一步也可以不写，因为defaultTargertDataSource就是该类所用的mytestdb）
//            DatabaseContextHolder.setDatabaseType(DatabaseType.test);
//        }
//        return point.proceed();//执行目标方法
//    }
    
}