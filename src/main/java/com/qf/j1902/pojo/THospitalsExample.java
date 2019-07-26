package com.qf.j1902.pojo;

import java.util.ArrayList;
import java.util.List;

public class THospitalsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public THospitalsExample() {
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

        public Criteria andHpidIsNull() {
            addCriterion("hpId is null");
            return (Criteria) this;
        }

        public Criteria andHpidIsNotNull() {
            addCriterion("hpId is not null");
            return (Criteria) this;
        }

        public Criteria andHpidEqualTo(Integer value) {
            addCriterion("hpId =", value, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidNotEqualTo(Integer value) {
            addCriterion("hpId <>", value, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidGreaterThan(Integer value) {
            addCriterion("hpId >", value, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hpId >=", value, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidLessThan(Integer value) {
            addCriterion("hpId <", value, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidLessThanOrEqualTo(Integer value) {
            addCriterion("hpId <=", value, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidIn(List<Integer> values) {
            addCriterion("hpId in", values, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidNotIn(List<Integer> values) {
            addCriterion("hpId not in", values, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidBetween(Integer value1, Integer value2) {
            addCriterion("hpId between", value1, value2, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidNotBetween(Integer value1, Integer value2) {
            addCriterion("hpId not between", value1, value2, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpnameIsNull() {
            addCriterion("hpName is null");
            return (Criteria) this;
        }

        public Criteria andHpnameIsNotNull() {
            addCriterion("hpName is not null");
            return (Criteria) this;
        }

        public Criteria andHpnameEqualTo(String value) {
            addCriterion("hpName =", value, "hpname");
            return (Criteria) this;
        }

        public Criteria andHpnameNotEqualTo(String value) {
            addCriterion("hpName <>", value, "hpname");
            return (Criteria) this;
        }

        public Criteria andHpnameGreaterThan(String value) {
            addCriterion("hpName >", value, "hpname");
            return (Criteria) this;
        }

        public Criteria andHpnameGreaterThanOrEqualTo(String value) {
            addCriterion("hpName >=", value, "hpname");
            return (Criteria) this;
        }

        public Criteria andHpnameLessThan(String value) {
            addCriterion("hpName <", value, "hpname");
            return (Criteria) this;
        }

        public Criteria andHpnameLessThanOrEqualTo(String value) {
            addCriterion("hpName <=", value, "hpname");
            return (Criteria) this;
        }

        public Criteria andHpnameLike(String value) {
            addCriterion("hpName like", value, "hpname");
            return (Criteria) this;
        }

        public Criteria andHpnameNotLike(String value) {
            addCriterion("hpName not like", value, "hpname");
            return (Criteria) this;
        }

        public Criteria andHpnameIn(List<String> values) {
            addCriterion("hpName in", values, "hpname");
            return (Criteria) this;
        }

        public Criteria andHpnameNotIn(List<String> values) {
            addCriterion("hpName not in", values, "hpname");
            return (Criteria) this;
        }

        public Criteria andHpnameBetween(String value1, String value2) {
            addCriterion("hpName between", value1, value2, "hpname");
            return (Criteria) this;
        }

        public Criteria andHpnameNotBetween(String value1, String value2) {
            addCriterion("hpName not between", value1, value2, "hpname");
            return (Criteria) this;
        }

        public Criteria andHpaddressIsNull() {
            addCriterion("hpAddress is null");
            return (Criteria) this;
        }

        public Criteria andHpaddressIsNotNull() {
            addCriterion("hpAddress is not null");
            return (Criteria) this;
        }

        public Criteria andHpaddressEqualTo(String value) {
            addCriterion("hpAddress =", value, "hpaddress");
            return (Criteria) this;
        }

        public Criteria andHpaddressNotEqualTo(String value) {
            addCriterion("hpAddress <>", value, "hpaddress");
            return (Criteria) this;
        }

        public Criteria andHpaddressGreaterThan(String value) {
            addCriterion("hpAddress >", value, "hpaddress");
            return (Criteria) this;
        }

        public Criteria andHpaddressGreaterThanOrEqualTo(String value) {
            addCriterion("hpAddress >=", value, "hpaddress");
            return (Criteria) this;
        }

        public Criteria andHpaddressLessThan(String value) {
            addCriterion("hpAddress <", value, "hpaddress");
            return (Criteria) this;
        }

        public Criteria andHpaddressLessThanOrEqualTo(String value) {
            addCriterion("hpAddress <=", value, "hpaddress");
            return (Criteria) this;
        }

        public Criteria andHpaddressLike(String value) {
            addCriterion("hpAddress like", value, "hpaddress");
            return (Criteria) this;
        }

        public Criteria andHpaddressNotLike(String value) {
            addCriterion("hpAddress not like", value, "hpaddress");
            return (Criteria) this;
        }

        public Criteria andHpaddressIn(List<String> values) {
            addCriterion("hpAddress in", values, "hpaddress");
            return (Criteria) this;
        }

        public Criteria andHpaddressNotIn(List<String> values) {
            addCriterion("hpAddress not in", values, "hpaddress");
            return (Criteria) this;
        }

        public Criteria andHpaddressBetween(String value1, String value2) {
            addCriterion("hpAddress between", value1, value2, "hpaddress");
            return (Criteria) this;
        }

        public Criteria andHpaddressNotBetween(String value1, String value2) {
            addCriterion("hpAddress not between", value1, value2, "hpaddress");
            return (Criteria) this;
        }

        public Criteria andProvidIsNull() {
            addCriterion("provId is null");
            return (Criteria) this;
        }

        public Criteria andProvidIsNotNull() {
            addCriterion("provId is not null");
            return (Criteria) this;
        }

        public Criteria andProvidEqualTo(Integer value) {
            addCriterion("provId =", value, "provid");
            return (Criteria) this;
        }

        public Criteria andProvidNotEqualTo(Integer value) {
            addCriterion("provId <>", value, "provid");
            return (Criteria) this;
        }

        public Criteria andProvidGreaterThan(Integer value) {
            addCriterion("provId >", value, "provid");
            return (Criteria) this;
        }

        public Criteria andProvidGreaterThanOrEqualTo(Integer value) {
            addCriterion("provId >=", value, "provid");
            return (Criteria) this;
        }

        public Criteria andProvidLessThan(Integer value) {
            addCriterion("provId <", value, "provid");
            return (Criteria) this;
        }

        public Criteria andProvidLessThanOrEqualTo(Integer value) {
            addCriterion("provId <=", value, "provid");
            return (Criteria) this;
        }

        public Criteria andProvidIn(List<Integer> values) {
            addCriterion("provId in", values, "provid");
            return (Criteria) this;
        }

        public Criteria andProvidNotIn(List<Integer> values) {
            addCriterion("provId not in", values, "provid");
            return (Criteria) this;
        }

        public Criteria andProvidBetween(Integer value1, Integer value2) {
            addCriterion("provId between", value1, value2, "provid");
            return (Criteria) this;
        }

        public Criteria andProvidNotBetween(Integer value1, Integer value2) {
            addCriterion("provId not between", value1, value2, "provid");
            return (Criteria) this;
        }

        public Criteria andCityidIsNull() {
            addCriterion("cityId is null");
            return (Criteria) this;
        }

        public Criteria andCityidIsNotNull() {
            addCriterion("cityId is not null");
            return (Criteria) this;
        }

        public Criteria andCityidEqualTo(Integer value) {
            addCriterion("cityId =", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotEqualTo(Integer value) {
            addCriterion("cityId <>", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThan(Integer value) {
            addCriterion("cityId >", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cityId >=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThan(Integer value) {
            addCriterion("cityId <", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThanOrEqualTo(Integer value) {
            addCriterion("cityId <=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidIn(List<Integer> values) {
            addCriterion("cityId in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotIn(List<Integer> values) {
            addCriterion("cityId not in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidBetween(Integer value1, Integer value2) {
            addCriterion("cityId between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotBetween(Integer value1, Integer value2) {
            addCriterion("cityId not between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andHptelIsNull() {
            addCriterion("hpTel is null");
            return (Criteria) this;
        }

        public Criteria andHptelIsNotNull() {
            addCriterion("hpTel is not null");
            return (Criteria) this;
        }

        public Criteria andHptelEqualTo(String value) {
            addCriterion("hpTel =", value, "hptel");
            return (Criteria) this;
        }

        public Criteria andHptelNotEqualTo(String value) {
            addCriterion("hpTel <>", value, "hptel");
            return (Criteria) this;
        }

        public Criteria andHptelGreaterThan(String value) {
            addCriterion("hpTel >", value, "hptel");
            return (Criteria) this;
        }

        public Criteria andHptelGreaterThanOrEqualTo(String value) {
            addCriterion("hpTel >=", value, "hptel");
            return (Criteria) this;
        }

        public Criteria andHptelLessThan(String value) {
            addCriterion("hpTel <", value, "hptel");
            return (Criteria) this;
        }

        public Criteria andHptelLessThanOrEqualTo(String value) {
            addCriterion("hpTel <=", value, "hptel");
            return (Criteria) this;
        }

        public Criteria andHptelLike(String value) {
            addCriterion("hpTel like", value, "hptel");
            return (Criteria) this;
        }

        public Criteria andHptelNotLike(String value) {
            addCriterion("hpTel not like", value, "hptel");
            return (Criteria) this;
        }

        public Criteria andHptelIn(List<String> values) {
            addCriterion("hpTel in", values, "hptel");
            return (Criteria) this;
        }

        public Criteria andHptelNotIn(List<String> values) {
            addCriterion("hpTel not in", values, "hptel");
            return (Criteria) this;
        }

        public Criteria andHptelBetween(String value1, String value2) {
            addCriterion("hpTel between", value1, value2, "hptel");
            return (Criteria) this;
        }

        public Criteria andHptelNotBetween(String value1, String value2) {
            addCriterion("hpTel not between", value1, value2, "hptel");
            return (Criteria) this;
        }

        public Criteria andHpinfoIsNull() {
            addCriterion("hpInfo is null");
            return (Criteria) this;
        }

        public Criteria andHpinfoIsNotNull() {
            addCriterion("hpInfo is not null");
            return (Criteria) this;
        }

        public Criteria andHpinfoEqualTo(String value) {
            addCriterion("hpInfo =", value, "hpinfo");
            return (Criteria) this;
        }

        public Criteria andHpinfoNotEqualTo(String value) {
            addCriterion("hpInfo <>", value, "hpinfo");
            return (Criteria) this;
        }

        public Criteria andHpinfoGreaterThan(String value) {
            addCriterion("hpInfo >", value, "hpinfo");
            return (Criteria) this;
        }

        public Criteria andHpinfoGreaterThanOrEqualTo(String value) {
            addCriterion("hpInfo >=", value, "hpinfo");
            return (Criteria) this;
        }

        public Criteria andHpinfoLessThan(String value) {
            addCriterion("hpInfo <", value, "hpinfo");
            return (Criteria) this;
        }

        public Criteria andHpinfoLessThanOrEqualTo(String value) {
            addCriterion("hpInfo <=", value, "hpinfo");
            return (Criteria) this;
        }

        public Criteria andHpinfoLike(String value) {
            addCriterion("hpInfo like", value, "hpinfo");
            return (Criteria) this;
        }

        public Criteria andHpinfoNotLike(String value) {
            addCriterion("hpInfo not like", value, "hpinfo");
            return (Criteria) this;
        }

        public Criteria andHpinfoIn(List<String> values) {
            addCriterion("hpInfo in", values, "hpinfo");
            return (Criteria) this;
        }

        public Criteria andHpinfoNotIn(List<String> values) {
            addCriterion("hpInfo not in", values, "hpinfo");
            return (Criteria) this;
        }

        public Criteria andHpinfoBetween(String value1, String value2) {
            addCriterion("hpInfo between", value1, value2, "hpinfo");
            return (Criteria) this;
        }

        public Criteria andHpinfoNotBetween(String value1, String value2) {
            addCriterion("hpInfo not between", value1, value2, "hpinfo");
            return (Criteria) this;
        }

        public Criteria andHpgradeIsNull() {
            addCriterion("hpGrade is null");
            return (Criteria) this;
        }

        public Criteria andHpgradeIsNotNull() {
            addCriterion("hpGrade is not null");
            return (Criteria) this;
        }

        public Criteria andHpgradeEqualTo(String value) {
            addCriterion("hpGrade =", value, "hpgrade");
            return (Criteria) this;
        }

        public Criteria andHpgradeNotEqualTo(String value) {
            addCriterion("hpGrade <>", value, "hpgrade");
            return (Criteria) this;
        }

        public Criteria andHpgradeGreaterThan(String value) {
            addCriterion("hpGrade >", value, "hpgrade");
            return (Criteria) this;
        }

        public Criteria andHpgradeGreaterThanOrEqualTo(String value) {
            addCriterion("hpGrade >=", value, "hpgrade");
            return (Criteria) this;
        }

        public Criteria andHpgradeLessThan(String value) {
            addCriterion("hpGrade <", value, "hpgrade");
            return (Criteria) this;
        }

        public Criteria andHpgradeLessThanOrEqualTo(String value) {
            addCriterion("hpGrade <=", value, "hpgrade");
            return (Criteria) this;
        }

        public Criteria andHpgradeLike(String value) {
            addCriterion("hpGrade like", value, "hpgrade");
            return (Criteria) this;
        }

        public Criteria andHpgradeNotLike(String value) {
            addCriterion("hpGrade not like", value, "hpgrade");
            return (Criteria) this;
        }

        public Criteria andHpgradeIn(List<String> values) {
            addCriterion("hpGrade in", values, "hpgrade");
            return (Criteria) this;
        }

        public Criteria andHpgradeNotIn(List<String> values) {
            addCriterion("hpGrade not in", values, "hpgrade");
            return (Criteria) this;
        }

        public Criteria andHpgradeBetween(String value1, String value2) {
            addCriterion("hpGrade between", value1, value2, "hpgrade");
            return (Criteria) this;
        }

        public Criteria andHpgradeNotBetween(String value1, String value2) {
            addCriterion("hpGrade not between", value1, value2, "hpgrade");
            return (Criteria) this;
        }

        public Criteria andHpskillIsNull() {
            addCriterion("hpskill is null");
            return (Criteria) this;
        }

        public Criteria andHpskillIsNotNull() {
            addCriterion("hpskill is not null");
            return (Criteria) this;
        }

        public Criteria andHpskillEqualTo(String value) {
            addCriterion("hpskill =", value, "hpskill");
            return (Criteria) this;
        }

        public Criteria andHpskillNotEqualTo(String value) {
            addCriterion("hpskill <>", value, "hpskill");
            return (Criteria) this;
        }

        public Criteria andHpskillGreaterThan(String value) {
            addCriterion("hpskill >", value, "hpskill");
            return (Criteria) this;
        }

        public Criteria andHpskillGreaterThanOrEqualTo(String value) {
            addCriterion("hpskill >=", value, "hpskill");
            return (Criteria) this;
        }

        public Criteria andHpskillLessThan(String value) {
            addCriterion("hpskill <", value, "hpskill");
            return (Criteria) this;
        }

        public Criteria andHpskillLessThanOrEqualTo(String value) {
            addCriterion("hpskill <=", value, "hpskill");
            return (Criteria) this;
        }

        public Criteria andHpskillLike(String value) {
            addCriterion("hpskill like", value, "hpskill");
            return (Criteria) this;
        }

        public Criteria andHpskillNotLike(String value) {
            addCriterion("hpskill not like", value, "hpskill");
            return (Criteria) this;
        }

        public Criteria andHpskillIn(List<String> values) {
            addCriterion("hpskill in", values, "hpskill");
            return (Criteria) this;
        }

        public Criteria andHpskillNotIn(List<String> values) {
            addCriterion("hpskill not in", values, "hpskill");
            return (Criteria) this;
        }

        public Criteria andHpskillBetween(String value1, String value2) {
            addCriterion("hpskill between", value1, value2, "hpskill");
            return (Criteria) this;
        }

        public Criteria andHpskillNotBetween(String value1, String value2) {
            addCriterion("hpskill not between", value1, value2, "hpskill");
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