package com.example.project.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VolunteerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VolunteerExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("UID is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("UID is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("UID =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("UID <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("UID >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("UID >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("UID <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("UID <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("UID in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("UID not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("UID between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("UID not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andAnthorityIsNull() {
            addCriterion("Anthority is null");
            return (Criteria) this;
        }

        public Criteria andAnthorityIsNotNull() {
            addCriterion("Anthority is not null");
            return (Criteria) this;
        }

        public Criteria andAnthorityEqualTo(String value) {
            addCriterion("Anthority =", value, "anthority");
            return (Criteria) this;
        }

        public Criteria andAnthorityNotEqualTo(String value) {
            addCriterion("Anthority <>", value, "anthority");
            return (Criteria) this;
        }

        public Criteria andAnthorityGreaterThan(String value) {
            addCriterion("Anthority >", value, "anthority");
            return (Criteria) this;
        }

        public Criteria andAnthorityGreaterThanOrEqualTo(String value) {
            addCriterion("Anthority >=", value, "anthority");
            return (Criteria) this;
        }

        public Criteria andAnthorityLessThan(String value) {
            addCriterion("Anthority <", value, "anthority");
            return (Criteria) this;
        }

        public Criteria andAnthorityLessThanOrEqualTo(String value) {
            addCriterion("Anthority <=", value, "anthority");
            return (Criteria) this;
        }

        public Criteria andAnthorityLike(String value) {
            addCriterion("Anthority like", value, "anthority");
            return (Criteria) this;
        }

        public Criteria andAnthorityNotLike(String value) {
            addCriterion("Anthority not like", value, "anthority");
            return (Criteria) this;
        }

        public Criteria andAnthorityIn(List<String> values) {
            addCriterion("Anthority in", values, "anthority");
            return (Criteria) this;
        }

        public Criteria andAnthorityNotIn(List<String> values) {
            addCriterion("Anthority not in", values, "anthority");
            return (Criteria) this;
        }

        public Criteria andAnthorityBetween(String value1, String value2) {
            addCriterion("Anthority between", value1, value2, "anthority");
            return (Criteria) this;
        }

        public Criteria andAnthorityNotBetween(String value1, String value2) {
            addCriterion("Anthority not between", value1, value2, "anthority");
            return (Criteria) this;
        }

        public Criteria andStartfromIsNull() {
            addCriterion("StartFrom is null");
            return (Criteria) this;
        }

        public Criteria andStartfromIsNotNull() {
            addCriterion("StartFrom is not null");
            return (Criteria) this;
        }

        public Criteria andStartfromEqualTo(Date value) {
            addCriterionForJDBCDate("StartFrom =", value, "startfrom");
            return (Criteria) this;
        }

        public Criteria andStartfromNotEqualTo(Date value) {
            addCriterionForJDBCDate("StartFrom <>", value, "startfrom");
            return (Criteria) this;
        }

        public Criteria andStartfromGreaterThan(Date value) {
            addCriterionForJDBCDate("StartFrom >", value, "startfrom");
            return (Criteria) this;
        }

        public Criteria andStartfromGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StartFrom >=", value, "startfrom");
            return (Criteria) this;
        }

        public Criteria andStartfromLessThan(Date value) {
            addCriterionForJDBCDate("StartFrom <", value, "startfrom");
            return (Criteria) this;
        }

        public Criteria andStartfromLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StartFrom <=", value, "startfrom");
            return (Criteria) this;
        }

        public Criteria andStartfromIn(List<Date> values) {
            addCriterionForJDBCDate("StartFrom in", values, "startfrom");
            return (Criteria) this;
        }

        public Criteria andStartfromNotIn(List<Date> values) {
            addCriterionForJDBCDate("StartFrom not in", values, "startfrom");
            return (Criteria) this;
        }

        public Criteria andStartfromBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StartFrom between", value1, value2, "startfrom");
            return (Criteria) this;
        }

        public Criteria andStartfromNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StartFrom not between", value1, value2, "startfrom");
            return (Criteria) this;
        }

        public Criteria andCareerIsNull() {
            addCriterion("Career is null");
            return (Criteria) this;
        }

        public Criteria andCareerIsNotNull() {
            addCriterion("Career is not null");
            return (Criteria) this;
        }

        public Criteria andCareerEqualTo(String value) {
            addCriterion("Career =", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerNotEqualTo(String value) {
            addCriterion("Career <>", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerGreaterThan(String value) {
            addCriterion("Career >", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerGreaterThanOrEqualTo(String value) {
            addCriterion("Career >=", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerLessThan(String value) {
            addCriterion("Career <", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerLessThanOrEqualTo(String value) {
            addCriterion("Career <=", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerLike(String value) {
            addCriterion("Career like", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerNotLike(String value) {
            addCriterion("Career not like", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerIn(List<String> values) {
            addCriterion("Career in", values, "career");
            return (Criteria) this;
        }

        public Criteria andCareerNotIn(List<String> values) {
            addCriterion("Career not in", values, "career");
            return (Criteria) this;
        }

        public Criteria andCareerBetween(String value1, String value2) {
            addCriterion("Career between", value1, value2, "career");
            return (Criteria) this;
        }

        public Criteria andCareerNotBetween(String value1, String value2) {
            addCriterion("Career not between", value1, value2, "career");
            return (Criteria) this;
        }

        public Criteria andHealthIsNull() {
            addCriterion("Health is null");
            return (Criteria) this;
        }

        public Criteria andHealthIsNotNull() {
            addCriterion("Health is not null");
            return (Criteria) this;
        }

        public Criteria andHealthEqualTo(String value) {
            addCriterion("Health =", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotEqualTo(String value) {
            addCriterion("Health <>", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthGreaterThan(String value) {
            addCriterion("Health >", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthGreaterThanOrEqualTo(String value) {
            addCriterion("Health >=", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthLessThan(String value) {
            addCriterion("Health <", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthLessThanOrEqualTo(String value) {
            addCriterion("Health <=", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthLike(String value) {
            addCriterion("Health like", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotLike(String value) {
            addCriterion("Health not like", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthIn(List<String> values) {
            addCriterion("Health in", values, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotIn(List<String> values) {
            addCriterion("Health not in", values, "health");
            return (Criteria) this;
        }

        public Criteria andHealthBetween(String value1, String value2) {
            addCriterion("Health between", value1, value2, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotBetween(String value1, String value2) {
            addCriterion("Health not between", value1, value2, "health");
            return (Criteria) this;
        }

        public Criteria andLocidIsNull() {
            addCriterion("LocID is null");
            return (Criteria) this;
        }

        public Criteria andLocidIsNotNull() {
            addCriterion("LocID is not null");
            return (Criteria) this;
        }

        public Criteria andLocidEqualTo(Integer value) {
            addCriterion("LocID =", value, "locid");
            return (Criteria) this;
        }

        public Criteria andLocidNotEqualTo(Integer value) {
            addCriterion("LocID <>", value, "locid");
            return (Criteria) this;
        }

        public Criteria andLocidGreaterThan(Integer value) {
            addCriterion("LocID >", value, "locid");
            return (Criteria) this;
        }

        public Criteria andLocidGreaterThanOrEqualTo(Integer value) {
            addCriterion("LocID >=", value, "locid");
            return (Criteria) this;
        }

        public Criteria andLocidLessThan(Integer value) {
            addCriterion("LocID <", value, "locid");
            return (Criteria) this;
        }

        public Criteria andLocidLessThanOrEqualTo(Integer value) {
            addCriterion("LocID <=", value, "locid");
            return (Criteria) this;
        }

        public Criteria andLocidIn(List<Integer> values) {
            addCriterion("LocID in", values, "locid");
            return (Criteria) this;
        }

        public Criteria andLocidNotIn(List<Integer> values) {
            addCriterion("LocID not in", values, "locid");
            return (Criteria) this;
        }

        public Criteria andLocidBetween(Integer value1, Integer value2) {
            addCriterion("LocID between", value1, value2, "locid");
            return (Criteria) this;
        }

        public Criteria andLocidNotBetween(Integer value1, Integer value2) {
            addCriterion("LocID not between", value1, value2, "locid");
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