/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\AutomicWatermeterApp\\RtuAssistant_1.0\\src\\com\\blg\\rtu\\aidl\\ServiceAidl.aidl
 */
package com.blg.rtu.aidl;
public interface ServiceAidl extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.blg.rtu.aidl.ServiceAidl
{
private static final java.lang.String DESCRIPTOR = "com.blg.rtu.aidl.ServiceAidl";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.blg.rtu.aidl.ServiceAidl interface,
 * generating a proxy if needed.
 */
public static com.blg.rtu.aidl.ServiceAidl asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.blg.rtu.aidl.ServiceAidl))) {
return ((com.blg.rtu.aidl.ServiceAidl)iin);
}
return new com.blg.rtu.aidl.ServiceAidl.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_registerActivityProxy:
{
data.enforceInterface(DESCRIPTOR);
com.blg.rtu.aidl.ActivityAidl _arg0;
_arg0 = com.blg.rtu.aidl.ActivityAidl.Stub.asInterface(data.readStrongBinder());
this.registerActivityProxy(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_sendRtuCommandByTcp:
{
data.enforceInterface(DESCRIPTOR);
com.blg.rtu.aidl.RemoteParcel _arg0;
if ((0!=data.readInt())) {
_arg0 = com.blg.rtu.aidl.RemoteParcel.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.sendRtuCommandByTcp(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_notSendCommandByCode:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.notSendCommandByCode(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_createSmCommandBySm:
{
data.enforceInterface(DESCRIPTOR);
com.blg.rtu.aidl.RemoteParcel _arg0;
if ((0!=data.readInt())) {
_arg0 = com.blg.rtu.aidl.RemoteParcel.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _result = this.createSmCommandBySm(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_sendRtuNoProtocolTxtDataByTcp:
{
data.enforceInterface(DESCRIPTOR);
com.blg.rtu.aidl.RemoteParcel _arg0;
if ((0!=data.readInt())) {
_arg0 = com.blg.rtu.aidl.RemoteParcel.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.sendRtuNoProtocolTxtDataByTcp(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_sendRtuNoProtocolHexDataByTcp:
{
data.enforceInterface(DESCRIPTOR);
com.blg.rtu.aidl.RemoteParcel _arg0;
if ((0!=data.readInt())) {
_arg0 = com.blg.rtu.aidl.RemoteParcel.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.sendRtuNoProtocolHexDataByTcp(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_dealSmData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.dealSmData(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_startTcpConnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.startTcpConnect(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isTcpConnected:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isTcpConnected();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getRtuId:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getRtuId();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_operateAutoQuery:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _arg2;
_arg2 = (0!=data.readInt());
boolean _arg3;
_arg3 = (0!=data.readInt());
java.lang.String _result = this.operateAutoQuery(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_operateAutoSet:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _arg2;
_arg2 = (0!=data.readInt());
boolean _arg3;
_arg3 = (0!=data.readInt());
java.lang.String _result = this.operateAutoSet(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_stopServer:
{
data.enforceInterface(DESCRIPTOR);
this.stopServer();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.blg.rtu.aidl.ServiceAidl
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
	 * 注册Activity的代理
	*/
@Override public void registerActivityProxy(com.blg.rtu.aidl.ActivityAidl proxy) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((proxy!=null))?(proxy.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerActivityProxy, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * 通过TCP网络通道发送RTU的命令
	*/
@Override public void sendRtuCommandByTcp(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((parcel!=null)) {
_data.writeInt(1);
parcel.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendRtuCommandByTcp, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * 所给功能码的命令不在发送
	*/
@Override public void notSendCommandByCode(java.lang.String code) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(code);
mRemote.transact(Stub.TRANSACTION_notSendCommandByCode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * 生成短信通道发送的RTU命令
	*/
@Override public java.lang.String createSmCommandBySm(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((parcel!=null)) {
_data.writeInt(1);
parcel.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createSmCommandBySm, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * 通过TCP网络通道发送非协议文本数据
	*/
@Override public void sendRtuNoProtocolTxtDataByTcp(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((parcel!=null)) {
_data.writeInt(1);
parcel.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendRtuNoProtocolTxtDataByTcp, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * 通过TCP网络通道发送非协议十六进制数据
	*/
@Override public void sendRtuNoProtocolHexDataByTcp(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((parcel!=null)) {
_data.writeInt(1);
parcel.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendRtuNoProtocolHexDataByTcp, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * 处理短信形式的RTU 上行数据
	*/
@Override public void dealSmData(java.lang.String smData) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(smData);
mRemote.transact(Stub.TRANSACTION_dealSmData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * 设置无异常，返回true,否则返回false
	*/
@Override public boolean startTcpConnect(java.lang.String url, int port) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
_data.writeInt(port);
mRemote.transact(Stub.TRANSACTION_startTcpConnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * 是否连接上了网络
	*/
@Override public boolean isTcpConnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isTcpConnected, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
    * 得到server层所查询得来的rtu id
    */
@Override public java.lang.String getRtuId() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getRtuId, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * 来自界面操作自动查询任务
	 * @param start
	 * @param pause
	 * @param resume
	 * @param stop
	 * @return
	 */
@Override public java.lang.String operateAutoQuery(boolean start, boolean pause, boolean resume, boolean stop) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((start)?(1):(0)));
_data.writeInt(((pause)?(1):(0)));
_data.writeInt(((resume)?(1):(0)));
_data.writeInt(((stop)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_operateAutoQuery, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * 来自界面操作自动设置任务
	 * @param start
	 * @param pause
	 * @param resume
	 * @param stop
	 * @return
	 */
@Override public java.lang.String operateAutoSet(boolean start, boolean pause, boolean resume, boolean stop) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((start)?(1):(0)));
_data.writeInt(((pause)?(1):(0)));
_data.writeInt(((resume)?(1):(0)));
_data.writeInt(((stop)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_operateAutoSet, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
    * 停止server，解除绑定Server可以系统杀死server，但是什么时杀就不定了
    */
@Override public void stopServer() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_stopServer, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_registerActivityProxy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_sendRtuCommandByTcp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_notSendCommandByCode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_createSmCommandBySm = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_sendRtuNoProtocolTxtDataByTcp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_sendRtuNoProtocolHexDataByTcp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_dealSmData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_startTcpConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_isTcpConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_getRtuId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_operateAutoQuery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_operateAutoSet = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_stopServer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
}
/**
	 * 注册Activity的代理
	*/
public void registerActivityProxy(com.blg.rtu.aidl.ActivityAidl proxy) throws android.os.RemoteException;
/**
	 * 通过TCP网络通道发送RTU的命令
	*/
public void sendRtuCommandByTcp(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException;
/**
	 * 所给功能码的命令不在发送
	*/
public void notSendCommandByCode(java.lang.String code) throws android.os.RemoteException;
/**
	 * 生成短信通道发送的RTU命令
	*/
public java.lang.String createSmCommandBySm(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException;
/**
	 * 通过TCP网络通道发送非协议文本数据
	*/
public void sendRtuNoProtocolTxtDataByTcp(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException;
/**
	 * 通过TCP网络通道发送非协议十六进制数据
	*/
public void sendRtuNoProtocolHexDataByTcp(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException;
/**
	 * 处理短信形式的RTU 上行数据
	*/
public void dealSmData(java.lang.String smData) throws android.os.RemoteException;
/**
	 * 设置无异常，返回true,否则返回false
	*/
public boolean startTcpConnect(java.lang.String url, int port) throws android.os.RemoteException;
/**
	 * 是否连接上了网络
	*/
public boolean isTcpConnected() throws android.os.RemoteException;
/**
    * 得到server层所查询得来的rtu id
    */
public java.lang.String getRtuId() throws android.os.RemoteException;
/**
	 * 来自界面操作自动查询任务
	 * @param start
	 * @param pause
	 * @param resume
	 * @param stop
	 * @return
	 */
public java.lang.String operateAutoQuery(boolean start, boolean pause, boolean resume, boolean stop) throws android.os.RemoteException;
/**
	 * 来自界面操作自动设置任务
	 * @param start
	 * @param pause
	 * @param resume
	 * @param stop
	 * @return
	 */
public java.lang.String operateAutoSet(boolean start, boolean pause, boolean resume, boolean stop) throws android.os.RemoteException;
/**
    * 停止server，解除绑定Server可以系统杀死server，但是什么时杀就不定了
    */
public void stopServer() throws android.os.RemoteException;
}
