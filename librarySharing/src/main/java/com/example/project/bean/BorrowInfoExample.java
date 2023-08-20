package com.example.project.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BorrowInfoExample() {
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

        public Criteria andBorrowidIsNull() {
            addCriterion("BorrowID is null");
            return (Criteria) this;
        }

        public Criteria andBorrowidIsNotNull() {
            addCriterion("BorrowID is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowidEqualTo(Integer value) {
            addCriterion("BorrowID =", value, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidNotEqualTo(Integer value) {
            addCriterion("BorrowID <>", value, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidGreaterThan(Integer value) {
            addCriterion("BorrowID >", value, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidGreaterThanOrEqualTo(Integer value) {
            addCriterion("BorrowID >=", value, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidLessThan(Integer value) {
            addCriterion("BorrowID <", value, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidLessThanOrEqualTo(Integer value) {
            addCriterion("BorrowID <=", value, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidIn(List<Integer> values) {
            addCriterion("BorrowID in", values, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidNotIn(List<Integer> values) {
            addCriterion("BorrowID not in", values, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidBetween(Integer value1, Integer value2) {
            addCriterion("BorrowID between", value1, value2, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidNotBetween(Integer value1, Integer value2) {
            addCriterion("BorrowID not between", value1, value2, "borrowid");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNull() {
            addCriterion("ISBN is null");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNotNull() {
            addCriterion("ISBN is not null");
            return (Criteria) this;
        }

        public Criteria andIsbnEqualTo(String value) {
            addCriterion("ISBN =", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotEqualTo(String value) {
            addCriterion("ISBN <>", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThan(String value) {
            addCriterion("ISBN >", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("ISBN >=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThan(String value) {
            addCriterion("ISBN <", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThanOrEqualTo(String value) {
            addCriterion("ISBN <=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLike(String value) {
            addCriterion("ISBN like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotLike(String value) {
            addCriterion("ISBN not like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnIn(List<String> values) {
            addCriterion("ISBN in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotIn(List<String> values) {
            addCriterion("ISBN not in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnBetween(String value1, String value2) {
            addCriterion("ISBN between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotBetween(String value1, String value2) {
            addCriterion("ISBN not between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andBidIsNull() {
            addCriterion("BID is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("BID is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Integer value) {
            addCriterion("BID =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Integer value) {
            addCriterion("BID <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Integer value) {
            addCriterion("BID >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("BID >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Integer value) {
            addCriterion("BID <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Integer value) {
            addCriterion("BID <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Integer> values) {
            addCriterion("BID in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Integer> values) {
            addCriterion("BID not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Integer value1, Integer value2) {
            addCriterion("BID between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Integer value1, Integer value2) {
            addCriterion("BID not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andAtstationIsNull() {
            addCriterion("atStation is null");
            return (Criteria) this;
        }

        public Criteria andAtstationIsNotNull() {
            addCriterion("atStation is not null");
            return (Criteria) this;
        }

        public Criteria andAtstationEqualTo(Integer value) {
            addCriterion("atStation =", value, "atstation");
            return (Criteria) this;
        }

        public Criteria andAtstationNotEqualTo(Integer value) {
            addCriterion("atStation <>", value, "atstation");
            return (Criteria) this;
        }

        public Criteria andAtstationGreaterThan(Integer value) {
            addCriterion("atStation >", value, "atstation");
            return (Criteria) this;
        }

        public Criteria andAtstationGreaterThanOrEqualTo(Integer value) {
            addCriterion("atStation >=", value, "atstation");
            return (Criteria) this;
        }

        public Criteria andAtstationLessThan(Integer value) {
            addCriterion("atStation <", value, "atstation");
            return (Criteria) this;
        }

        public Criteria andAtstationLessThanOrEqualTo(Integer value) {
            addCriterion("atStation <=", value, "atstation");
            return (Criteria) this;
        }

        public Criteria andAtstationIn(List<Integer> values) {
            addCriterion("atStation in", values, "atstation");
            return (Criteria) this;
        }

        public Criteria andAtstationNotIn(List<Integer> values) {
            addCriterion("atStation not in", values, "atstation");
            return (Criteria) this;
        }

        public Criteria andAtstationBetween(Integer value1, Integer value2) {
            addCriterion("atStation between", value1, value2, "atstation");
            return (Criteria) this;
        }

        public Criteria andAtstationNotBetween(Integer value1, Integer value2) {
            addCriterion("atStation not between", value1, value2, "atstation");
            return (Criteria) this;
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

        public Criteria andBorrowatIsNull() {
            addCriterion("BorrowAt is null");
            return (Criteria) this;
        }

        public Criteria andBorrowatIsNotNull() {
            addCriterion("BorrowAt is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowatEqualTo(Integer value) {
            addCriterion("BorrowAt =", value, "borrowat");
            return (Criteria) this;
        }

        public Criteria andBorrowatNotEqualTo(Integer value) {
            addCriterion("BorrowAt <>", value, "borrowat");
            return (Criteria) this;
        }

        public Criteria andBorrowatGreaterThan(Integer value) {
            addCriterion("BorrowAt >", value, "borrowat");
            return (Criteria) this;
        }

        public Criteria andBorrowatGreaterThanOrEqualTo(Integer value) {
            addCriterion("BorrowAt >=", value, "borrowat");
            return (Criteria) this;
        }

        public Criteria andBorrowatLessThan(Integer value) {
            addCriterion("BorrowAt <", value, "borrowat");
            return (Criteria) this;
        }

        public Criteria andBorrowatLessThanOrEqualTo(Integer value) {
            addCriterion("BorrowAt <=", value, "borrowat");
            return (Criteria) this;
        }

        public Criteria andBorrowatIn(List<Integer> values) {
            addCriterion("BorrowAt in", values, "borrowat");
            return (Criteria) this;
        }

        public Criteria andBorrowatNotIn(List<Integer> values) {
            addCriterion("BorrowAt not in", values, "borrowat");
            return (Criteria) this;
        }

        public Criteria andBorrowatBetween(Integer value1, Integer value2) {
            addCriterion("BorrowAt between", value1, value2, "borrowat");
            return (Criteria) this;
        }

        public Criteria andBorrowatNotBetween(Integer value1, Integer value2) {
            addCriterion("BorrowAt not between", value1, value2, "borrowat");
            return (Criteria) this;
        }

        public Criteria andRenewalIsNull() {
            addCriterion("Renewal is null");
            return (Criteria) this;
        }

        public Criteria andRenewalIsNotNull() {
            addCriterion("Renewal is not null");
            return (Criteria) this;
        }

        public Criteria andRenewalEqualTo(Integer value) {
            addCriterion("Renewal =", value, "renewal");
            return (Criteria) this;
        }

        public Criteria andRenewalNotEqualTo(Integer value) {
            addCriterion("Renewal <>", value, "renewal");
            return (Criteria) this;
        }

        public Criteria andRenewalGreaterThan(Integer value) {
            addCriterion("Renewal >", value, "renewal");
            return (Criteria) this;
        }

        public Criteria andRenewalGreaterThanOrEqualTo(Integer value) {
            addCriterion("Renewal >=", value, "renewal");
            return (Criteria) this;
        }

        public Criteria andRenewalLessThan(Integer value) {
            addCriterion("Renewal <", value, "renewal");
            return (Criteria) this;
        }

        public Criteria andRenewalLessThanOrEqualTo(Integer value) {
            addCriterion("Renewal <=", value, "renewal");
            return (Criteria) this;
        }

        public Criteria andRenewalIn(List<Integer> values) {
            addCriterion("Renewal in", values, "renewal");
            return (Criteria) this;
        }

        public Criteria andRenewalNotIn(List<Integer> values) {
            addCriterion("Renewal not in", values, "renewal");
            return (Criteria) this;
        }

        public Criteria andRenewalBetween(Integer value1, Integer value2) {
            addCriterion("Renewal between", value1, value2, "renewal");
            return (Criteria) this;
        }

        public Criteria andRenewalNotBetween(Integer value1, Integer value2) {
            addCriterion("Renewal not between", value1, value2, "renewal");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeIsNull() {
            addCriterion("BorrowTime is null");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeIsNotNull() {
            addCriterion("BorrowTime is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeEqualTo(Date value) {
            addCriterion("BorrowTime =", value, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeNotEqualTo(Date value) {
            addCriterion("BorrowTime <>", value, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeGreaterThan(Date value) {
            addCriterion("BorrowTime >", value, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BorrowTime >=", value, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeLessThan(Date value) {
            addCriterion("BorrowTime <", value, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeLessThanOrEqualTo(Date value) {
            addCriterion("BorrowTime <=", value, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeIn(List<Date> values) {
            addCriterion("BorrowTime in", values, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeNotIn(List<Date> values) {
            addCriterion("BorrowTime not in", values, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeBetween(Date value1, Date value2) {
            addCriterion("BorrowTime between", value1, value2, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeNotBetween(Date value1, Date value2) {
            addCriterion("BorrowTime not between", value1, value2, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andDuetimeIsNull() {
            addCriterion("DueTime is null");
            return (Criteria) this;
        }

        public Criteria andDuetimeIsNotNull() {
            addCriterion("DueTime is not null");
            return (Criteria) this;
        }

        public Criteria andDuetimeEqualTo(Date value) {
            addCriterion("DueTime =", value, "duetime");
            return (Criteria) this;
        }

        public Criteria andDuetimeNotEqualTo(Date value) {
            addCriterion("DueTime <>", value, "duetime");
            return (Criteria) this;
        }

        public Criteria andDuetimeGreaterThan(Date value) {
            addCriterion("DueTime >", value, "duetime");
            return (Criteria) this;
        }

        public Criteria andDuetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DueTime >=", value, "duetime");
            return (Criteria) this;
        }

        public Criteria andDuetimeLessThan(Date value) {
            addCriterion("DueTime <", value, "duetime");
            return (Criteria) this;
        }

        public Criteria andDuetimeLessThanOrEqualTo(Date value) {
            addCriterion("DueTime <=", value, "duetime");
            return (Criteria) this;
        }

        public Criteria andDuetimeIn(List<Date> values) {
            addCriterion("DueTime in", values, "duetime");
            return (Criteria) this;
        }

        public Criteria andDuetimeNotIn(List<Date> values) {
            addCriterion("DueTime not in", values, "duetime");
            return (Criteria) this;
        }

        public Criteria andDuetimeBetween(Date value1, Date value2) {
            addCriterion("DueTime between", value1, value2, "duetime");
            return (Criteria) this;
        }

        public Criteria andDuetimeNotBetween(Date value1, Date value2) {
            addCriterion("DueTime not between", value1, value2, "duetime");
            return (Criteria) this;
        }

        public Criteria andReturntimeIsNull() {
            addCriterion("ReturnTime is null");
            return (Criteria) this;
        }

        public Criteria andReturntimeIsNotNull() {
            addCriterion("ReturnTime is not null");
            return (Criteria) this;
        }

        public Criteria andReturntimeEqualTo(Date value) {
            addCriterion("ReturnTime =", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotEqualTo(Date value) {
            addCriterion("ReturnTime <>", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeGreaterThan(Date value) {
            addCriterion("ReturnTime >", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ReturnTime >=", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeLessThan(Date value) {
            addCriterion("ReturnTime <", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeLessThanOrEqualTo(Date value) {
            addCriterion("ReturnTime <=", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeIn(List<Date> values) {
            addCriterion("ReturnTime in", values, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotIn(List<Date> values) {
            addCriterion("ReturnTime not in", values, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeBetween(Date value1, Date value2) {
            addCriterion("ReturnTime between", value1, value2, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotBetween(Date value1, Date value2) {
            addCriterion("ReturnTime not between", value1, value2, "returntime");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusIsNull() {
            addCriterion("borrowStatus is null");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusIsNotNull() {
            addCriterion("borrowStatus is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusEqualTo(String value) {
            addCriterion("borrowStatus =", value, "borrowstatus");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusNotEqualTo(String value) {
            addCriterion("borrowStatus <>", value, "borrowstatus");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusGreaterThan(String value) {
            addCriterion("borrowStatus >", value, "borrowstatus");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusGreaterThanOrEqualTo(String value) {
            addCriterion("borrowStatus >=", value, "borrowstatus");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusLessThan(String value) {
            addCriterion("borrowStatus <", value, "borrowstatus");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusLessThanOrEqualTo(String value) {
            addCriterion("borrowStatus <=", value, "borrowstatus");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusLike(String value) {
            addCriterion("borrowStatus like", value, "borrowstatus");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusNotLike(String value) {
            addCriterion("borrowStatus not like", value, "borrowstatus");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusIn(List<String> values) {
            addCriterion("borrowStatus in", values, "borrowstatus");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusNotIn(List<String> values) {
            addCriterion("borrowStatus not in", values, "borrowstatus");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusBetween(String value1, String value2) {
            addCriterion("borrowStatus between", value1, value2, "borrowstatus");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusNotBetween(String value1, String value2) {
            addCriterion("borrowStatus not between", value1, value2, "borrowstatus");
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