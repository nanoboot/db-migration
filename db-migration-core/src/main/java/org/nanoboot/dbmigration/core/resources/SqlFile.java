///////////////////////////////////////////////////////////////////////////////////////////////
// db-migration: A database schema versioning tool.
// Copyright (C) 2021-2022 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation;
// version 2.1 of the License only.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
///////////////////////////////////////////////////////////////////////////////////////////////

package org.nanoboot.dbmigration.core.resources;

import lombok.Data;
import org.nanoboot.dbmigration.core.utils.DBMigrationUtils;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.1.0
 */
@Data
public class SqlFile implements Comparable<SqlFile> {

    private SqlFileName sqlFileName;
    private String fileName;
    private String content;

    public SqlFile(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.sqlFileName = new SqlFileName(fileName);
    }

    public String calculateHash() {
        return DBMigrationUtils.hashSha1(content);
    }

    @Override
    public int compareTo(SqlFile o) {
        return this.getSqlFileName().compareTo(o.getSqlFileName());
    }
}