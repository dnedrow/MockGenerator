class MockOverloadProtocol: OverloadProtocol {

    var invokedSetValueStringForKey = false
    var invokedSetValueStringForKeyCount = 0
    var invokedSetValueStringForKeyParameters: (string: String, key: String)?
    func setValue(_ string: String, forKey key: String) {
        invokedSetValueStringForKey = true
        invokedSetValueStringForKeyParameters = (string, key)
    }
    var invokedSetValueIntForKey = false
    var invokedSetValueIntForKeyCount = 0
    var invokedSetValueIntForKeyParameters: (int: Int, key: String)?
    func setValue(_ int: Int, forKey key: String) {
        invokedSetValueIntForKey = true
        invokedSetValueIntForKeyParameters = (int, key)
    }
    var invokedSetValueString = false
    var invokedSetValueStringCount = 0
    var invokedSetValueStringParameters: (value: String, Void)?
    func set(value: String) {
        invokedSetValueString = true
        invokedSetValueStringParameters = (value, ())
    }
    var invokedSetValueInt = false
    var invokedSetValueIntCount = 0
    var invokedSetValueIntParameters: (value: Int, Void)?
    func set(value: Int) {
        invokedSetValueInt = true
        invokedSetValueIntParameters = (value, ())
    }
    var invokedAnimate = false
    var invokedAnimateCount = 0
    var stubbedAnimateResult: Bool!
    func animate() -> Bool {
        invokedAnimate = true
        return stubbedAnimateResult
    }
    var invokedAnimateWithDuration = false
    var invokedAnimateWithDurationCount = 0
    var invokedAnimateWithDurationParameters: (duration: TimeInterval, Void)?
    func animate(withDuration duration: TimeInterval) {
        invokedAnimateWithDuration = true
        invokedAnimateWithDurationParameters = (duration, ())
    }
    var invokedAnimateWithDurationDelay = false
    var invokedAnimateWithDurationDelayCount = 0
    var invokedAnimateWithDurationDelayParameters: (duration: TimeInterval, delay: TimeInterval)?
    func animate(withDuration duration: TimeInterval, delay: TimeInterval) {
        invokedAnimateWithDurationDelay = true
        invokedAnimateWithDurationDelayParameters = (duration, delay)
    }
    var invokedPresent = false
    var invokedPresentCount = 0
    var invokedPresentParameters: (viewControllerToPresent: UIViewController, Void)?
    func present(_ viewControllerToPresent: UIViewController) {
        invokedPresent = true
        invokedPresentParameters = (viewControllerToPresent, ())
    }
    var invokedPresentAnimated = false
    var invokedPresentAnimatedCount = 0
    var invokedPresentAnimatedParameters: (viewControllerToPresent: UIViewController, animated: Bool)?
    func present(_ viewControllerToPresent: UIViewController, animated: Bool) {
        invokedPresentAnimated = true
        invokedPresentAnimatedParameters = (viewControllerToPresent, animated)
    }
    var invokedPresentFromUIViewController = false
    var invokedPresentFromUIViewControllerCount = 0
    var invokedPresentFromUIViewControllerParameters: (viewControllerToPresent: UIViewController, Void)?
    func present(from viewControllerToPresent: UIViewController) {
        invokedPresentFromUIViewController = true
        invokedPresentFromUIViewControllerParameters = (viewControllerToPresent, ())
    }
    var invokedPresentFromUINavigationController = false
    var invokedPresentFromUINavigationControllerCount = 0
    var invokedPresentFromUINavigationControllerParameters: (viewControllerToPresent: UINavigationController, Void)?
    func present(from viewControllerToPresent: UINavigationController) {
        invokedPresentFromUINavigationController = true
        invokedPresentFromUINavigationControllerParameters = (viewControllerToPresent, ())
    }
}
