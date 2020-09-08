package types;

import annotations.Table;
import exceptions.TableNotAnnotatedException;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log
public class Query  {

    private String tableName;
    private List<String> selectionSet;
    private Integer limit;
    private Integer offset;
    private List<Join> joins;
    private List<String> where;

    String getQuery() {

        String selectStatement = selectionSet.stream().map(
                (fieldName) -> {
                    return String.format("%s.%s", tableName, fieldName);
                }
        ).collect(Collectors.joining(","));

        String joinStatement = String.join("and\n", joins.stream().map(
                join -> {
                    return join.getJoinString();
                }
        ).collect(Collectors.toList()));

        String whereStatement = String.join(" and\n", where);

        List<String> queryParts = new ArrayList<>();
        queryParts.add(String.format("select %s", selectStatement));
        queryParts.add(String.format("from %s", tableName));
        queryParts.add(joinStatement);
        queryParts.add(String.format("where %s", whereStatement));
        queryParts.add(String.format("limit %d, %d", limit, offset));

        return String.join("\n", queryParts);

    }

    List getRecords() {
        return new ArrayList<>();
    }

    public static class Builder  {


        private String tableName;
        private List<String> selectionSet = new ArrayList<>();
        private Integer limit = 10;
        private Integer offset = 0;
        private List<Join> joins = new ArrayList<>();
        private List<String> where = new ArrayList<>();


        public Builder select(String fields[]) {
            this.selectionSet.addAll(Arrays.asList(fields));
            return this;
        }

        public Builder select(String field) {
            this.selectionSet.add(field);
            return this;
        }

        public Builder limit(int limit) { this.limit = limit; return this; }
        public Builder offset(int offset) { this.offset = offset; return this; }
        public Builder (String tableName) { this.tableName = tableName; }
        public Builder (Class tableClass) throws TableNotAnnotatedException {
            if (tableClass.isAnnotationPresent(Table.class)) {
                Table table = (Table) tableClass.getAnnotation(Table.class);
                this.tableName = table.name();
            } else {
                throw new TableNotAnnotatedException(tableClass.getName());
            }
        }

        public Builder join(Join join) {
            this.joins.add(join);
            return this;
        }

        public Builder where(String clause) {
            this.where.add(clause);
            return this;
        }

        private Query _build() {
            Query q = new Query();
            q.tableName = this.tableName;
            q.selectionSet = this.selectionSet;
            q.joins = this.joins;
            q.limit = this.limit;
            q.offset = this.offset;
            q.where = this.where;
            return q;
        }

        public Query build() {
            return _build();
        }

        public String getQuery() {
            return _build().getQuery();
        }

        public List getRecords() {
            return _build().getRecords();
        }

    }






}
