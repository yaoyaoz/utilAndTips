/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xq.foundation.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2019-9-18")
public class ThriftResultStrcut implements org.apache.thrift.TBase<ThriftResultStrcut, ThriftResultStrcut._Fields>, java.io.Serializable, Cloneable, Comparable<ThriftResultStrcut> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ThriftResultStrcut");

  private static final org.apache.thrift.protocol.TField RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("result", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField INFO_FIELD_DESC = new org.apache.thrift.protocol.TField("info", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("data", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField EXT_FIELD_DESC = new org.apache.thrift.protocol.TField("ext", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ThriftResultStrcutStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ThriftResultStrcutTupleSchemeFactory());
  }

  public int result; // required
  public String info; // required
  public String data; // required
  public ByteBuffer ext; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESULT((short)1, "result"),
    INFO((short)2, "info"),
    DATA((short)3, "data"),
    EXT((short)4, "ext");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // RESULT
          return RESULT;
        case 2: // INFO
          return INFO;
        case 3: // DATA
          return DATA;
        case 4: // EXT
          return EXT;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __RESULT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESULT, new org.apache.thrift.meta_data.FieldMetaData("result", org.apache.thrift.TFieldRequirementType.DEFAULT,
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.INFO, new org.apache.thrift.meta_data.FieldMetaData("info", org.apache.thrift.TFieldRequirementType.DEFAULT,
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DATA, new org.apache.thrift.meta_data.FieldMetaData("data", org.apache.thrift.TFieldRequirementType.DEFAULT,
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EXT, new org.apache.thrift.meta_data.FieldMetaData("ext", org.apache.thrift.TFieldRequirementType.DEFAULT,
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ThriftResultStrcut.class, metaDataMap);
  }

  public ThriftResultStrcut() {
  }

  public ThriftResultStrcut(
          int result,
          String info,
          String data,
          ByteBuffer ext)
  {
    this();
    this.result = result;
    setResultIsSet(true);
    this.info = info;
    this.data = data;
    this.ext = org.apache.thrift.TBaseHelper.copyBinary(ext);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftResultStrcut(ThriftResultStrcut other) {
    __isset_bitfield = other.__isset_bitfield;
    this.result = other.result;
    if (other.isSetInfo()) {
      this.info = other.info;
    }
    if (other.isSetData()) {
      this.data = other.data;
    }
    if (other.isSetExt()) {
      this.ext = org.apache.thrift.TBaseHelper.copyBinary(other.ext);
    }
  }

  public ThriftResultStrcut deepCopy() {
    return new ThriftResultStrcut(this);
  }

  @Override
  public void clear() {
    setResultIsSet(false);
    this.result = 0;
    this.info = null;
    this.data = null;
    this.ext = null;
  }

  public int getResult() {
    return this.result;
  }

  public ThriftResultStrcut setResult(int result) {
    this.result = result;
    setResultIsSet(true);
    return this;
  }

  public void unsetResult() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __RESULT_ISSET_ID);
  }

  /** Returns true if field result is set (has been assigned a value) and false otherwise */
  public boolean isSetResult() {
    return EncodingUtils.testBit(__isset_bitfield, __RESULT_ISSET_ID);
  }

  public void setResultIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __RESULT_ISSET_ID, value);
  }

  public String getInfo() {
    return this.info;
  }

  public ThriftResultStrcut setInfo(String info) {
    this.info = info;
    return this;
  }

  public void unsetInfo() {
    this.info = null;
  }

  /** Returns true if field info is set (has been assigned a value) and false otherwise */
  public boolean isSetInfo() {
    return this.info != null;
  }

  public void setInfoIsSet(boolean value) {
    if (!value) {
      this.info = null;
    }
  }

  public String getData() {
    return this.data;
  }

  public ThriftResultStrcut setData(String data) {
    this.data = data;
    return this;
  }

  public void unsetData() {
    this.data = null;
  }

  /** Returns true if field data is set (has been assigned a value) and false otherwise */
  public boolean isSetData() {
    return this.data != null;
  }

  public void setDataIsSet(boolean value) {
    if (!value) {
      this.data = null;
    }
  }

  public byte[] getExt() {
    setExt(org.apache.thrift.TBaseHelper.rightSize(ext));
    return ext == null ? null : ext.array();
  }

  public ByteBuffer bufferForExt() {
    return org.apache.thrift.TBaseHelper.copyBinary(ext);
  }

  public ThriftResultStrcut setExt(byte[] ext) {
    this.ext = ext == null ? (ByteBuffer)null : ByteBuffer.wrap(Arrays.copyOf(ext, ext.length));
    return this;
  }

  public ThriftResultStrcut setExt(ByteBuffer ext) {
    this.ext = org.apache.thrift.TBaseHelper.copyBinary(ext);
    return this;
  }

  public void unsetExt() {
    this.ext = null;
  }

  /** Returns true if field ext is set (has been assigned a value) and false otherwise */
  public boolean isSetExt() {
    return this.ext != null;
  }

  public void setExtIsSet(boolean value) {
    if (!value) {
      this.ext = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
      case RESULT:
        if (value == null) {
          unsetResult();
        } else {
          setResult((Integer)value);
        }
        break;

      case INFO:
        if (value == null) {
          unsetInfo();
        } else {
          setInfo((String)value);
        }
        break;

      case DATA:
        if (value == null) {
          unsetData();
        } else {
          setData((String)value);
        }
        break;

      case EXT:
        if (value == null) {
          unsetExt();
        } else {
          setExt((ByteBuffer)value);
        }
        break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
      case RESULT:
        return Integer.valueOf(getResult());

      case INFO:
        return getInfo();

      case DATA:
        return getData();

      case EXT:
        return getExt();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
      case RESULT:
        return isSetResult();
      case INFO:
        return isSetInfo();
      case DATA:
        return isSetData();
      case EXT:
        return isSetExt();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftResultStrcut)
      return this.equals((ThriftResultStrcut)that);
    return false;
  }

  public boolean equals(ThriftResultStrcut that) {
    if (that == null)
      return false;

//    boolean this_present_result = true;
//    boolean that_present_result = true;
//    if (this_present_result || that_present_result) {
//      if (!(this_present_result && that_present_result))
//        return false;
    if (this.result != that.result)
      return false;
//    }

    boolean this_present_info = true && this.isSetInfo();
    boolean that_present_info = true && that.isSetInfo();
    if (this_present_info || that_present_info) {
      if (!(this_present_info && that_present_info))
        return false;
      if (!this.info.equals(that.info))
        return false;
    }

    boolean this_present_data = true && this.isSetData();
    boolean that_present_data = true && that.isSetData();
    if (this_present_data || that_present_data) {
      if (!(this_present_data && that_present_data))
        return false;
      if (!this.data.equals(that.data))
        return false;
    }

    boolean this_present_ext = true && this.isSetExt();
    boolean that_present_ext = true && that.isSetExt();
    if (this_present_ext || that_present_ext) {
      if (!(this_present_ext && that_present_ext))
        return false;
      if (!this.ext.equals(that.ext))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_result = true;
    list.add(present_result);
    if (present_result)
      list.add(result);

    boolean present_info = true && (isSetInfo());
    list.add(present_info);
    if (present_info)
      list.add(info);

    boolean present_data = true && (isSetData());
    list.add(present_data);
    if (present_data)
      list.add(data);

    boolean present_ext = true && (isSetExt());
    list.add(present_ext);
    if (present_ext)
      list.add(ext);

    return list.hashCode();
  }

  @Override
  public int compareTo(ThriftResultStrcut other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetResult()).compareTo(other.isSetResult());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResult()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.result, other.result);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetInfo()).compareTo(other.isSetInfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.info, other.info);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetData()).compareTo(other.isSetData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data, other.data);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExt()).compareTo(other.isSetExt());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExt()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ext, other.ext);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ThriftResultStrcut(");
    boolean first = true;

    sb.append("result:");
    sb.append(this.result);
    first = false;
    if (!first) sb.append(", ");
    sb.append("info:");
    if (this.info == null) {
      sb.append("null");
    } else {
      sb.append(this.info);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("data:");
    if (this.data == null) {
      sb.append("null");
    } else {
      sb.append(this.data);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("ext:");
    if (this.ext == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.ext, sb);
    }
    //first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ThriftResultStrcutStandardSchemeFactory implements SchemeFactory {
    public ThriftResultStrcutStandardScheme getScheme() {
      return new ThriftResultStrcutStandardScheme();
    }
  }

  private static class ThriftResultStrcutStandardScheme extends StandardScheme<ThriftResultStrcut> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ThriftResultStrcut struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
          break;
        }
        switch (schemeField.id) {
          case 1: // RESULT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.result = iprot.readI32();
              struct.setResultIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // INFO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.info = iprot.readString();
              struct.setInfoIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.data = iprot.readString();
              struct.setDataIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // EXT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.ext = iprot.readBinary();
              struct.setExtIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ThriftResultStrcut struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(RESULT_FIELD_DESC);
      oprot.writeI32(struct.result);
      oprot.writeFieldEnd();
      if (struct.info != null) {
        oprot.writeFieldBegin(INFO_FIELD_DESC);
        oprot.writeString(struct.info);
        oprot.writeFieldEnd();
      }
      if (struct.data != null) {
        oprot.writeFieldBegin(DATA_FIELD_DESC);
        oprot.writeString(struct.data);
        oprot.writeFieldEnd();
      }
      if (struct.ext != null) {
        oprot.writeFieldBegin(EXT_FIELD_DESC);
        oprot.writeBinary(struct.ext);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ThriftResultStrcutTupleSchemeFactory implements SchemeFactory {
    public ThriftResultStrcutTupleScheme getScheme() {
      return new ThriftResultStrcutTupleScheme();
    }
  }

  private static class ThriftResultStrcutTupleScheme extends TupleScheme<ThriftResultStrcut> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ThriftResultStrcut struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetResult()) {
        optionals.set(0);
      }
      if (struct.isSetInfo()) {
        optionals.set(1);
      }
      if (struct.isSetData()) {
        optionals.set(2);
      }
      if (struct.isSetExt()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetResult()) {
        oprot.writeI32(struct.result);
      }
      if (struct.isSetInfo()) {
        oprot.writeString(struct.info);
      }
      if (struct.isSetData()) {
        oprot.writeString(struct.data);
      }
      if (struct.isSetExt()) {
        oprot.writeBinary(struct.ext);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ThriftResultStrcut struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.result = iprot.readI32();
        struct.setResultIsSet(true);
      }
      if (incoming.get(1)) {
        struct.info = iprot.readString();
        struct.setInfoIsSet(true);
      }
      if (incoming.get(2)) {
        struct.data = iprot.readString();
        struct.setDataIsSet(true);
      }
      if (incoming.get(3)) {
        struct.ext = iprot.readBinary();
        struct.setExtIsSet(true);
      }
    }
  }

}

