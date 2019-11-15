CREATE TABLE "public"."company"
(
    "id"           serial8     NOT NULL PRIMARY KEY,
    "company_name" VARCHAR(30) NOT NULL,
    "create_time"  TIMESTAMP(6),
    "update_time"  TIMESTAMP(6)
);
ALTER TABLE "public"."company"
    OWNER TO "postgres";
COMMENT ON COLUMN "public"."company"."company_name" IS '公司名称';

CREATE TABLE "public"."department"
(
    "id"          serial8 NOT NULL PRIMARY KEY,
    "company_id"  int8 NOT NULL ,
    "dept_name"   varchar(30) NOT NULL ,
    "create_time" timestamp(6),
    "update_time" timestamp(6)
)
;

ALTER TABLE "public"."department"
    OWNER TO "postgres";

COMMENT ON COLUMN "public"."department"."company_id" IS '公司id';

COMMENT ON COLUMN "public"."department"."dept_name" IS '部门名称';

CREATE TABLE "public"."employee"
(
    "id"              serial8     NOT NULL,
    "employee_name"   varchar(30) NOT NULL,
    "company_id"      int8        NOT NULL,
    "dept_id"         int8        NOT NULL,
    "create_time"     timestamp(6),
    "update_time"     timestamp(6),
    "employee_gender" int2,
    CONSTRAINT "employee_pkey" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."employee"
    OWNER TO "postgres";

COMMENT ON COLUMN "public"."employee"."id" IS '员工Id';

COMMENT ON COLUMN "public"."employee"."employee_name" IS '员工姓名';

COMMENT ON COLUMN "public"."employee"."company_id" IS '公司id';

COMMENT ON COLUMN "public"."employee"."dept_id" IS '部门id';

COMMENT ON COLUMN "public"."employee"."create_time" IS '创建时间';

COMMENT ON COLUMN "public"."employee"."update_time" IS '修改时间';

COMMENT ON COLUMN "public"."employee"."employee_gender" IS '性别，1：男，2：女';