/*
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.github.adejanovski.cassandra.jdbc;

import java.nio.ByteBuffer;
import java.sql.RowId;

import org.apache.cassandra.utils.ByteBufferUtil;

class CassandraRowId implements RowId
{
    private final ByteBuffer bytes;
    
    public CassandraRowId (ByteBuffer bytes)
    {
        this.bytes = bytes;
    }

    public byte[] getBytes()
    {
        return ByteBufferUtil.getArray(bytes);
    }
    
    public String toString()
    {
        return ByteBufferUtil.bytesToHex(bytes);
    }

    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bytes == null) ? 0 : bytes.hashCode());
        return result;
    }

    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        CassandraRowId other = (CassandraRowId) obj;
        if (bytes == null)
        {
            if (other.bytes != null) return false;
        }
        else if (!bytes.equals(other.bytes)) return false;
        return true;
    }
}
