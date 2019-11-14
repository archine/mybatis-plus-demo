CREATE TABLE "public"."company"
(
    "id"           serial8 NOT NULL PRIMARY KEY,
    "company_name" VARCHAR(30) COLLATE "pg_catalog"."default",
    "create_time"  TIMESTAMP(6),
    "update_time"  TIMESTAMP(6)
);
ALTER TABLE "public"."company"
    OWNER TO "postgres";
COMMENT ON COLUMN "public"."company"."company_name" IS '公司名称';

CREATE TABLE "public"."department"
(
    "id"          serial8 NOT NULL PRIMARY KEY,
    "company_id"  int8,
    "dept_name"   varchar(30) COLLATE "pg_catalog"."default",
    "create_time" timestamp(6),
    "update_time" timestamp(6)
)
;

ALTER TABLE "public"."department"
    OWNER TO "postgres";

COMMENT ON COLUMN "public"."department"."company_id" IS '公司id';

COMMENT ON COLUMN "public"."department"."dept_name" IS '部门名称';