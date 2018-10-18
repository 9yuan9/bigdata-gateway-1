package com.weein.common.log;
//package com.weein.common.log;
//
//import java.lang.reflect.InvocationTargetException;
//import java.sql.Connection;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Properties;
//import java.sql.Statement;
//
//import org.apache.ibatis.executor.parameter.ParameterHandler;
//import org.apache.ibatis.executor.statement.RoutingStatementHandler;
//import org.apache.ibatis.executor.statement.StatementHandler;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Invocation;
//import org.apache.ibatis.plugin.Plugin;
//import org.apache.ibatis.plugin.Signature;
//import org.apache.ibatis.session.ResultHandler;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Intercepts(value={/*@Signature(type=StatementHandler.class,method="batch",args={Statement.class})
//,*/@Signature(type=StatementHandler.class,method="update",args={Statement.class})
//,@Signature(type=StatementHandler.class,method="query",args={Statement.class,ResultHandler.class})}) 
//public class SqlLogInterceptor implements Interceptor {
//	private static final Logger LOG = LoggerFactory.getLogger(SqlLogInterceptor.class);
//	
//	private static final SimpleDateFormat sdf = new SimpleDateFormat(
//			"yyyy-MM-dd HH:mm:ss.SSS");
//	@Override
//	public Object intercept(Invocation invocation) throws Throwable {
//		
//		if(invocation.getTarget() instanceof RoutingStatementHandler){   
//			Date start = new Date();
//			StringBuilder logBuilder = new StringBuilder();
//            RoutingStatementHandler statementHandler = (RoutingStatementHandler)invocation.getTarget();    
//            StatementHandler delegate = (StatementHandler) ReflectHelper.getFieldValue(statementHandler, "delegate");    
//            ParameterHandler parameterHandler = delegate.getParameterHandler();
//            MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getFieldValue(parameterHandler, "mappedStatement");   
//            if(mappedStatement.getId().endsWith("!selectKey")){
//            	return invocation.proceed();
//            }
//            logBuilder.append(mappedStatement.getId());
//            logBuilder.append("(");
//            logBuilder.append("\""+parameterHandler.getParameterObject()+"\"");
//            logBuilder.append(")");
//            boolean isException = false;
//            try{
//    			Object object = invocation.proceed();
//    			return object;
//    		}catch(InvocationTargetException e){
//    			isException=true;
//    			printThrowing(logBuilder.toString(), LOG, e.getTargetException());
//    			throw e;
//    		}finally{
//    			if(!isException && invocation.getTarget() instanceof RoutingStatementHandler){    
//    				Date end = new Date();
//    				printLog(logBuilder.toString(), start, end, LOG);
//    			}
//    			
//    		}
//        }else{
//        	return invocation.proceed();
//        }
//		
//		
//	}
//	private static void printThrowing(String message,Logger log, Throwable ex) {
//		StringBuffer buf = new StringBuffer(message);
//		buf.append(" 异常[").append(ex.toString()).append("]");
//		printLog(buf.toString(), null, new Date(), log);
//	}
//	
//	private static void printLog(String message, Date start, Date end,
//			Logger log) {
//		StringBuffer buf = new StringBuffer(message);
//		if (null != start) {
//			buf.append(",开始时间[").append(sdf.format(start)).append("]");
//		}
//		if (null != end) {
//			buf.append(",结束时间[").append(sdf.format(end)).append("]");
//		}
//		if (null != start && null != end) {
//			buf.append(",用时[").append(end.getTime() - start.getTime())
//					.append("]ms");
//			log.info(buf.toString());
//		} else {
//			log.error(buf.toString());
//		}
//
//	}
//	@Override
//	public Object plugin(Object target) {
//		if (target instanceof StatementHandler) {    
//            return Plugin.wrap(target, this);    
//        } else {    
//            return target;    
//        }   
//	}
//
//	@Override
//	public void setProperties(Properties properties) {
//	}
//
//}
