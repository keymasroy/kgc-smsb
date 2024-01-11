export const useFunctionAuthCheck = functionId => {
  const currentMenuId = $ustra.management.store.navigation.currentProgramMenu.mnuId

  let authData = false
  if ($ustra.management.auth.hasMenuAuthority(currentMenuId)) {
    $ustra.auth.store.roles.forEach(async role => {
      if (role.split(':')[0] === currentMenuId && role.split(':')[2] === functionId) {
        authData = true
      }
    })
  }
  return authData
}

export const ipAddrChecker = function () {
  const ipAddress = $ustra.auth.user.accessInfo.userIp
  let isAccess = false

  // 공통코드에서 화이트리스트 IP를 조회하여 사용자 IP와 비교
  // 화이트리스트에 포함되어 있으면 true 로 리턴
  useUstraCodeList('WHITELIST_IP', true).forEach(v => {
    if (v.dtlCd.includes(ipAddress)) {
      isAccess = true
      return
    }
  })

  return isAccess
}
