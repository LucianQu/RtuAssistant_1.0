/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: G:\\AutomicWatermeterApp\\RtuAssistant_1.0\\src\\com\\blg\\rtu\\aidl\\ActivityAidl.aidl
 */
package com.blg.rtu.aidl;
public interface ActivityAidl extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.blg.rtu.aidl.ActivityAidl
{
private static final java.lang.String DESCRIPTOR = "com.blg.rtu.aidl.ActivityAidl";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.blg.rtu.aidl.ActivityAidl interface,
 * generating a proxy if needed.
 */
public static com.blg.rtu.aidl.ActivityAidl asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.blg.rtu.aidl.ActivityAidl))) {
return ((com.blg.rtu.aidl.ActivityAidl)iin);
}
return new com.blg.rtu.aidl.ActivityAidl.Stub.Proxy(obj);
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
case TRANSACTION_rtuCommandResult:
{
data.enforceInterface(DESCRIPTOR);
com.blg.rtu.aidl.RemoteParcel _arg0;
if ((0!=data.readInt())) {
_arg0 = com.blg.rtu.aidl.RemoteParcel.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.rtuCommandResult(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_rtuNoPtotocolData:
{
data.enforceInterface(DESCRIPTOR);
com.blg.rtu.aidl.RemoteParcel _arg0;
if ((0!=data.readInt())) {
_arg0 = com.blg.rtu.aidl.RemoteParcel.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.rtuNoPtotocolData(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_commandSendedCallBack:
{
data.enforceInterface(DESCRIPTOR);
com.blg.rtu.aidl.RemoteParcel _arg0;
if ((0!=data.readInt())) {
_arg0 = com.blg.rtu.aidl.RemoteParcel.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.commandSendedCallBack(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_autoQueryCommand:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.autoQueryCommand(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_autoSetCommand:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.autoSetCommand(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_rtuReportData:
{
data.enforceInterface(DESCRIPTOR);
com.blg.rtu.aidl.RemoteParcel _arg0;
if ((0!=data.readInt())) {
_arg0 = com.blg.rtu.aidl.RemoteParcel.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.rtuReportData(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_newRtuId:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.newRtuId(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_netConnected:
{
data.enforceInterface(DESCRIPTOR);
this.netConnected();
reply.writeNoException();
return true;
}
case TRANSACTION_netDisconnect:
{
data.enforceInterface(DESCRIPTOR);
this.netDisconnect();
reply.writeNoException();
return true;
}
case TRANSACTION_notifyAutoQueryStatus:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.notifyAutoQueryStatus(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_notifyAutoSetStatus:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.notifyAutoSetStatus(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.blg.rtu.aidl.ActivityAidl
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
// 收到rtu命令结果数据,把其传Activity层

@Override public void rtuCommandResult(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException
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
mRemote.transact(Stub.TRANSACTION_rtuCommandResult, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// 收到rtu非协议(调试)数据

@Override public void rtuNoPtotocolData(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException
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
mRemote.transact(Stub.TRANSACTION_rtuNoPtotocolData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// 把rtu命令回传给Activity层以显示，以及更新命令发送状态

@Override public void commandSendedCallBack(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException
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
mRemote.transact(Stub.TRANSACTION_commandSendedCallBack, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//后台服务启动自动查询命令

@Override public void autoQueryCommand(java.lang.String code) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(code);
mRemote.transact(Stub.TRANSACTION_autoQueryCommand, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//后台服务启动自动设置命令

@Override public void autoSetCommand(java.lang.String code) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(code);
mRemote.transact(Stub.TRANSACTION_autoSetCommand, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// 收到rtu主动上报数据,把其传Activity层

@Override public void rtuReportData(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException
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
mRemote.transact(Stub.TRANSACTION_rtuReportData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// 新RTU地址,把其传Activity层

@Override public void newRtuId(java.lang.String id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(id);
mRemote.transact(Stub.TRANSACTION_newRtuId, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//网络连接上了,通知Activity层

@Override public void netConnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_netConnected, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//网络连接断了,通知Activity层  

@Override public void netDisconnect() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_netDisconnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//向界面通知自动查询状态

@Override public void notifyAutoQueryStatus(java.lang.String status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(status);
mRemote.transact(Stub.TRANSACTION_notifyAutoQueryStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//向界面通知自动设置状态

@Override public void notifyAutoSetStatus(java.lang.String status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(status);
mRemote.transact(Stub.TRANSACTION_notifyAutoSetStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_rtuCommandResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_rtuNoPtotocolData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_commandSendedCallBack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_autoQueryCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_autoSetCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_rtuReportData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_newRtuId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_netConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_netDisconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_notifyAutoQueryStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_notifyAutoSetStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
}
// 收到rtu命令结果数据,把其传Activity层

public void rtuCommandResult(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException;
// 收到rtu非协议(调试)数据

public void rtuNoPtotocolData(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException;
// 把rtu命令回传给Activity层以显示，以及更新命令发送状态

public void commandSendedCallBack(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException;
//后台服务启动自动查询命令

public void autoQueryCommand(java.lang.String code) throws android.os.RemoteException;
//后台服务启动自动设置命令

public void autoSetCommand(java.lang.String code) throws android.os.RemoteException;
// 收到rtu主动上报数据,把其传Activity层

public void rtuReportData(com.blg.rtu.aidl.RemoteParcel parcel) throws android.os.RemoteException;
// 新RTU地址,把其传Activity层

public void newRtuId(java.lang.String id) throws android.os.RemoteException;
//网络连接上了,通知Activity层

public void netConnected() throws android.os.RemoteException;
//网络连接断了,通知Activity层  

public void netDisconnect() throws android.os.RemoteException;
//向界面通知自动查询状态

public void notifyAutoQueryStatus(java.lang.String status) throws android.os.RemoteException;
//向界面通知自动设置状态

public void notifyAutoSetStatus(java.lang.String status) throws android.os.RemoteException;
}
