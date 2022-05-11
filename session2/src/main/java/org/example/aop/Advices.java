package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class Advices {

    @Pointcut("execution(* org.example.aop.Ledger.put(..))")
    public void ledgerPutPointcut() {
    }

    @Pointcut("execution(void org.example.aop.Ledger.trimLedger(..))")
    public void ledgerTrimPointcut() {
    }

    @Pointcut("execution(void org.example.aop.Ledger.printLedger(..))")
    public void ledgerPrintPointcut() {
    }


    @Before("ledgerPutPointcut()")
    public void beforeLedgerPutPointcut(JoinPoint joinPoint) {
        System.out.println("[I'm about to add another entry to the ledger (" + Arrays.toString(joinPoint.getArgs()) + ")...]");
    }

//    @Before("ledgerPrintPointcut()")
//    public void addNewLineAndLabel(){
//        System.out.println();
//        System.out.println("Ledger: ");
//    }

    @Around("ledgerTrimPointcut()")
    public Object suppressInvalidLedgerTrim(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("[Checking ledger trim arguments...]");

        if (proceedingJoinPoint.getArgs() == null ||
            proceedingJoinPoint.getArgs().length == 0 ||
            !(proceedingJoinPoint.getArgs()[0] instanceof Integer) ||
            ((Integer) proceedingJoinPoint.getArgs()[0]) < 0
        ) {
            System.out.println("[Invalid argument - suppressing call to Ledger.trimLedger()...]");
            return null;
        }

        System.out.println("[Argument checks out ok - allowing call to Ledger.trimLedger()...]");
        return proceedingJoinPoint.proceed();
    }
}
