def win(): 
  local_40 = 0;
  param_3=??????
  param_1=((param_3 + 8) >> 1) + 1;
  if (local_40 == 0) {
    uVar6 = UNITY_FT_Stream_Seek((long)param_2,*(ulong *)(param_3 + 0x10));
    local_40 = (int)uVar6;
  #  if ((local_40 == 0) &&(local_40 = UNITY_FT_Stream_EnterFrame(param_2,(ulong)*(ushort *)(param_3 + 8)), local_40 == 0)) {
      uVar2 = *(ushort *)(param_3 + 8);
      pcVar8 = pcVar5;
      local_3c = param_5;
      local_38 = (code *)param_4;
      if ((uVar2 & 0xfffe) != 0) {
        pcVar3 = (char *)param_2[8];
        lVar7 = 0;
        cVar1 = *pcVar3;
        while( true ) {
          if ((cVar1 == '\0') &&
             ((iVar4 = (*local_38)((int)pcVar3[lVar7 * 2 + 1]), iVar4 != 0 ||
              ((char)local_3c != '\0')))) {
            *pcVar8 = pcVar3[lVar7 * 2 + 1];
            pcVar8 = pcVar8 + 1;
          }
          lVar7 = lVar7 + 1;
          if ((uint)(uVar2 >> 1) == (uint)lVar7) break;
          cVar1 = pcVar3[lVar7 * 2];
        }
      }
      *pcVar8 = '\0';
      UNITY_FT_Stream_ExitFrame(param_2);
      return pcVar5;
    }
    UNITY_ft_mem_free(param_1,(long)pcVar5);
    *(undefined2 *)(param_3 + 8) = 0;
    *(undefined8 *)(param_3 + 0x10) = 0;
    UNITY_ft_mem_free(param_1,*(long *)(param_3 + 0x18));
    *(undefined8 *)(param_3 + 0x18) = 0;
  }
  return (char *)0x0;
  print(param_1, local_40)

win()