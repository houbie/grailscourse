databaseChangeLog = {

    changeSet(author: "ivo (generated)", id: "1432618659781-1") {
        createTable(tableName: "person") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "personPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "first_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "last_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "class", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "address", type: "VARCHAR(255)")

            column(name: "city", type: "VARCHAR(255)")

            column(name: "telephone", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "ivo (generated)", id: "1432618659781-2") {
        createTable(tableName: "pet") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "petPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "birth_date", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "owner_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "type_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ivo (generated)", id: "1432618659781-3") {
        createTable(tableName: "pet_type") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "pet_typePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(20)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ivo (generated)", id: "1432618659781-4") {
        createTable(tableName: "speciality") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "specialityPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(20)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ivo (generated)", id: "1432618659781-5") {
        createTable(tableName: "vet_speciality") {
            column(name: "vet_specialities_id", type: "BIGINT")

            column(name: "speciality_id", type: "BIGINT")
        }
    }

    changeSet(author: "ivo (generated)", id: "1432618659781-6") {
        createTable(tableName: "visit") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "visitPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "date", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "pet_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ivo (generated)", id: "1432618659781-7") {
        addUniqueConstraint(columnNames: "name", constraintName: "UC_PET_TYPENAME_COL", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "pet_type")
    }

    changeSet(author: "ivo (generated)", id: "1432618659781-8") {
        addUniqueConstraint(columnNames: "name", constraintName: "UC_SPECIALITYNAME_COL", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "speciality")
    }

    changeSet(author: "ivo (generated)", id: "1432618659781-9") {
        addForeignKeyConstraint(baseColumnNames: "vet_specialities_id", baseTableName: "vet_speciality", constraintName: "FK_2y6r6dv8pf8b3fxvwek33exqy", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person")
    }

    changeSet(author: "ivo (generated)", id: "1432618659781-10") {
        addForeignKeyConstraint(baseColumnNames: "owner_id", baseTableName: "pet", constraintName: "FK_98le5nat0hd479mg10eua8xn0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person")
    }

    changeSet(author: "ivo (generated)", id: "1432618659781-11") {
        addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "pet", constraintName: "FK_f265r1o5eddpmock5mflwfywl", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pet_type")
    }

    changeSet(author: "ivo (generated)", id: "1432618659781-12") {
        addForeignKeyConstraint(baseColumnNames: "pet_id", baseTableName: "visit", constraintName: "FK_ifoofk96i1wm1ck2eu2518ehq", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pet")
    }

    changeSet(author: "ivo (generated)", id: "1432618659781-13") {
        addForeignKeyConstraint(baseColumnNames: "speciality_id", baseTableName: "vet_speciality", constraintName: "FK_obpuagylkoe92jbh89228tfam", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "speciality")
    }
}
