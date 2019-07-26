package com.qf.j1902.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
@Data
public class HealtharticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HealtharticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andPscienceidIsNull() {
            addCriterion("pscienceID is null");
            return (Criteria) this;
        }

        public Criteria andPscienceidIsNotNull() {
            addCriterion("pscienceID is not null");
            return (Criteria) this;
        }

        public Criteria andPscienceidEqualTo(Integer value) {
            addCriterion("pscienceID =", value, "pscienceid");
            return (Criteria) this;
        }

        public Criteria andPscienceidNotEqualTo(Integer value) {
            addCriterion("pscienceID <>", value, "pscienceid");
            return (Criteria) this;
        }

        public Criteria andPscienceidGreaterThan(Integer value) {
            addCriterion("pscienceID >", value, "pscienceid");
            return (Criteria) this;
        }

        public Criteria andPscienceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pscienceID >=", value, "pscienceid");
            return (Criteria) this;
        }

        public Criteria andPscienceidLessThan(Integer value) {
            addCriterion("pscienceID <", value, "pscienceid");
            return (Criteria) this;
        }

        public Criteria andPscienceidLessThanOrEqualTo(Integer value) {
            addCriterion("pscienceID <=", value, "pscienceid");
            return (Criteria) this;
        }

        public Criteria andPscienceidIn(List<Integer> values) {
            addCriterion("pscienceID in", values, "pscienceid");
            return (Criteria) this;
        }

        public Criteria andPscienceidNotIn(List<Integer> values) {
            addCriterion("pscienceID not in", values, "pscienceid");
            return (Criteria) this;
        }

        public Criteria andPscienceidBetween(Integer value1, Integer value2) {
            addCriterion("pscienceID between", value1, value2, "pscienceid");
            return (Criteria) this;
        }

        public Criteria andPscienceidNotBetween(Integer value1, Integer value2) {
            addCriterion("pscienceID not between", value1, value2, "pscienceid");
            return (Criteria) this;
        }

        public Criteria andPstitleIsNull() {
            addCriterion("pstitle is null");
            return (Criteria) this;
        }

        public Criteria andPstitleIsNotNull() {
            addCriterion("pstitle is not null");
            return (Criteria) this;
        }

        public Criteria andPstitleEqualTo(String value) {
            addCriterion("pstitle =", value, "pstitle");
            return (Criteria) this;
        }

        public Criteria andPstitleNotEqualTo(String value) {
            addCriterion("pstitle <>", value, "pstitle");
            return (Criteria) this;
        }

        public Criteria andPstitleGreaterThan(String value) {
            addCriterion("pstitle >", value, "pstitle");
            return (Criteria) this;
        }

        public Criteria andPstitleGreaterThanOrEqualTo(String value) {
            addCriterion("pstitle >=", value, "pstitle");
            return (Criteria) this;
        }

        public Criteria andPstitleLessThan(String value) {
            addCriterion("pstitle <", value, "pstitle");
            return (Criteria) this;
        }

        public Criteria andPstitleLessThanOrEqualTo(String value) {
            addCriterion("pstitle <=", value, "pstitle");
            return (Criteria) this;
        }

        public Criteria andPstitleLike(String value) {
            addCriterion("pstitle like", value, "pstitle");
            return (Criteria) this;
        }

        public Criteria andPstitleNotLike(String value) {
            addCriterion("pstitle not like", value, "pstitle");
            return (Criteria) this;
        }

        public Criteria andPstitleIn(List<String> values) {
            addCriterion("pstitle in", values, "pstitle");
            return (Criteria) this;
        }

        public Criteria andPstitleNotIn(List<String> values) {
            addCriterion("pstitle not in", values, "pstitle");
            return (Criteria) this;
        }

        public Criteria andPstitleBetween(String value1, String value2) {
            addCriterion("pstitle between", value1, value2, "pstitle");
            return (Criteria) this;
        }

        public Criteria andPstitleNotBetween(String value1, String value2) {
            addCriterion("pstitle not between", value1, value2, "pstitle");
            return (Criteria) this;
        }

        public Criteria andPsintroduceIsNull() {
            addCriterion("psintroduce is null");
            return (Criteria) this;
        }

        public Criteria andPsintroduceIsNotNull() {
            addCriterion("psintroduce is not null");
            return (Criteria) this;
        }

        public Criteria andPsintroduceEqualTo(String value) {
            addCriterion("psintroduce =", value, "psintroduce");
            return (Criteria) this;
        }

        public Criteria andPsintroduceNotEqualTo(String value) {
            addCriterion("psintroduce <>", value, "psintroduce");
            return (Criteria) this;
        }

        public Criteria andPsintroduceGreaterThan(String value) {
            addCriterion("psintroduce >", value, "psintroduce");
            return (Criteria) this;
        }

        public Criteria andPsintroduceGreaterThanOrEqualTo(String value) {
            addCriterion("psintroduce >=", value, "psintroduce");
            return (Criteria) this;
        }

        public Criteria andPsintroduceLessThan(String value) {
            addCriterion("psintroduce <", value, "psintroduce");
            return (Criteria) this;
        }

        public Criteria andPsintroduceLessThanOrEqualTo(String value) {
            addCriterion("psintroduce <=", value, "psintroduce");
            return (Criteria) this;
        }

        public Criteria andPsintroduceLike(String value) {
            addCriterion("psintroduce like", value, "psintroduce");
            return (Criteria) this;
        }

        public Criteria andPsintroduceNotLike(String value) {
            addCriterion("psintroduce not like", value, "psintroduce");
            return (Criteria) this;
        }

        public Criteria andPsintroduceIn(List<String> values) {
            addCriterion("psintroduce in", values, "psintroduce");
            return (Criteria) this;
        }

        public Criteria andPsintroduceNotIn(List<String> values) {
            addCriterion("psintroduce not in", values, "psintroduce");
            return (Criteria) this;
        }

        public Criteria andPsintroduceBetween(String value1, String value2) {
            addCriterion("psintroduce between", value1, value2, "psintroduce");
            return (Criteria) this;
        }

        public Criteria andPsintroduceNotBetween(String value1, String value2) {
            addCriterion("psintroduce not between", value1, value2, "psintroduce");
            return (Criteria) this;
        }

        public Criteria andPsauthorIsNull() {
            addCriterion("psAuthor is null");
            return (Criteria) this;
        }

        public Criteria andPsauthorIsNotNull() {
            addCriterion("psAuthor is not null");
            return (Criteria) this;
        }

        public Criteria andPsauthorEqualTo(String value) {
            addCriterion("psAuthor =", value, "psauthor");
            return (Criteria) this;
        }

        public Criteria andPsauthorNotEqualTo(String value) {
            addCriterion("psAuthor <>", value, "psauthor");
            return (Criteria) this;
        }

        public Criteria andPsauthorGreaterThan(String value) {
            addCriterion("psAuthor >", value, "psauthor");
            return (Criteria) this;
        }

        public Criteria andPsauthorGreaterThanOrEqualTo(String value) {
            addCriterion("psAuthor >=", value, "psauthor");
            return (Criteria) this;
        }

        public Criteria andPsauthorLessThan(String value) {
            addCriterion("psAuthor <", value, "psauthor");
            return (Criteria) this;
        }

        public Criteria andPsauthorLessThanOrEqualTo(String value) {
            addCriterion("psAuthor <=", value, "psauthor");
            return (Criteria) this;
        }

        public Criteria andPsauthorLike(String value) {
            addCriterion("psAuthor like", value, "psauthor");
            return (Criteria) this;
        }

        public Criteria andPsauthorNotLike(String value) {
            addCriterion("psAuthor not like", value, "psauthor");
            return (Criteria) this;
        }

        public Criteria andPsauthorIn(List<String> values) {
            addCriterion("psAuthor in", values, "psauthor");
            return (Criteria) this;
        }

        public Criteria andPsauthorNotIn(List<String> values) {
            addCriterion("psAuthor not in", values, "psauthor");
            return (Criteria) this;
        }

        public Criteria andPsauthorBetween(String value1, String value2) {
            addCriterion("psAuthor between", value1, value2, "psauthor");
            return (Criteria) this;
        }

        public Criteria andPsauthorNotBetween(String value1, String value2) {
            addCriterion("psAuthor not between", value1, value2, "psauthor");
            return (Criteria) this;
        }

        public Criteria andPsimageIsNull() {
            addCriterion("psimage is null");
            return (Criteria) this;
        }

        public Criteria andPsimageIsNotNull() {
            addCriterion("psimage is not null");
            return (Criteria) this;
        }

        public Criteria andPsimageEqualTo(String value) {
            addCriterion("psimage =", value, "psimage");
            return (Criteria) this;
        }

        public Criteria andPsimageNotEqualTo(String value) {
            addCriterion("psimage <>", value, "psimage");
            return (Criteria) this;
        }

        public Criteria andPsimageGreaterThan(String value) {
            addCriterion("psimage >", value, "psimage");
            return (Criteria) this;
        }

        public Criteria andPsimageGreaterThanOrEqualTo(String value) {
            addCriterion("psimage >=", value, "psimage");
            return (Criteria) this;
        }

        public Criteria andPsimageLessThan(String value) {
            addCriterion("psimage <", value, "psimage");
            return (Criteria) this;
        }

        public Criteria andPsimageLessThanOrEqualTo(String value) {
            addCriterion("psimage <=", value, "psimage");
            return (Criteria) this;
        }

        public Criteria andPsimageLike(String value) {
            addCriterion("psimage like", value, "psimage");
            return (Criteria) this;
        }

        public Criteria andPsimageNotLike(String value) {
            addCriterion("psimage not like", value, "psimage");
            return (Criteria) this;
        }

        public Criteria andPsimageIn(List<String> values) {
            addCriterion("psimage in", values, "psimage");
            return (Criteria) this;
        }

        public Criteria andPsimageNotIn(List<String> values) {
            addCriterion("psimage not in", values, "psimage");
            return (Criteria) this;
        }

        public Criteria andPsimageBetween(String value1, String value2) {
            addCriterion("psimage between", value1, value2, "psimage");
            return (Criteria) this;
        }

        public Criteria andPsimageNotBetween(String value1, String value2) {
            addCriterion("psimage not between", value1, value2, "psimage");
            return (Criteria) this;
        }

        public Criteria andFenleiIsNull() {
            addCriterion("fenlei is null");
            return (Criteria) this;
        }

        public Criteria andFenleiIsNotNull() {
            addCriterion("fenlei is not null");
            return (Criteria) this;
        }

        public Criteria andFenleiEqualTo(String value) {
            addCriterion("fenlei =", value, "fenlei");
            return (Criteria) this;
        }

        public Criteria andFenleiNotEqualTo(String value) {
            addCriterion("fenlei <>", value, "fenlei");
            return (Criteria) this;
        }

        public Criteria andFenleiGreaterThan(String value) {
            addCriterion("fenlei >", value, "fenlei");
            return (Criteria) this;
        }

        public Criteria andFenleiGreaterThanOrEqualTo(String value) {
            addCriterion("fenlei >=", value, "fenlei");
            return (Criteria) this;
        }

        public Criteria andFenleiLessThan(String value) {
            addCriterion("fenlei <", value, "fenlei");
            return (Criteria) this;
        }

        public Criteria andFenleiLessThanOrEqualTo(String value) {
            addCriterion("fenlei <=", value, "fenlei");
            return (Criteria) this;
        }

        public Criteria andFenleiLike(String value) {
            addCriterion("fenlei like", value, "fenlei");
            return (Criteria) this;
        }

        public Criteria andFenleiNotLike(String value) {
            addCriterion("fenlei not like", value, "fenlei");
            return (Criteria) this;
        }

        public Criteria andFenleiIn(List<String> values) {
            addCriterion("fenlei in", values, "fenlei");
            return (Criteria) this;
        }

        public Criteria andFenleiNotIn(List<String> values) {
            addCriterion("fenlei not in", values, "fenlei");
            return (Criteria) this;
        }

        public Criteria andFenleiBetween(String value1, String value2) {
            addCriterion("fenlei between", value1, value2, "fenlei");
            return (Criteria) this;
        }

        public Criteria andFenleiNotBetween(String value1, String value2) {
            addCriterion("fenlei not between", value1, value2, "fenlei");
            return (Criteria) this;
        }

        public Criteria andIfValidIsNull() {
            addCriterion("if_valid is null");
            return (Criteria) this;
        }

        public Criteria andIfValidIsNotNull() {
            addCriterion("if_valid is not null");
            return (Criteria) this;
        }

        public Criteria andIfValidEqualTo(Byte value) {
            addCriterion("if_valid =", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidNotEqualTo(Byte value) {
            addCriterion("if_valid <>", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidGreaterThan(Byte value) {
            addCriterion("if_valid >", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidGreaterThanOrEqualTo(Byte value) {
            addCriterion("if_valid >=", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidLessThan(Byte value) {
            addCriterion("if_valid <", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidLessThanOrEqualTo(Byte value) {
            addCriterion("if_valid <=", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidIn(List<Byte> values) {
            addCriterion("if_valid in", values, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidNotIn(List<Byte> values) {
            addCriterion("if_valid not in", values, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidBetween(Byte value1, Byte value2) {
            addCriterion("if_valid between", value1, value2, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidNotBetween(Byte value1, Byte value2) {
            addCriterion("if_valid not between", value1, value2, "ifValid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}